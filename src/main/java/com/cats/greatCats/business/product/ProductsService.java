package com.cats.greatCats.business.product;

import com.cats.greatCats.Company;
import com.cats.greatCats.business.product.component.ProductComponentService;
import com.cats.greatCats.business.product.dto.*;
import com.cats.greatCats.domain.company.CompanyService;
import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.ProductMapper;
import com.cats.greatCats.domain.product.ProductService;
import com.cats.greatCats.domain.product.component.Component;
import com.cats.greatCats.domain.product.component.ComponentRepository;
import com.cats.greatCats.domain.product.component.ProductComponent;
import com.cats.greatCats.domain.product.component.ProductComponentMapper;
import com.cats.greatCats.domain.product.image.Image;
import com.cats.greatCats.domain.product.image.ImageMapper;
import com.cats.greatCats.domain.product.image.ImageService;
import com.cats.greatCats.domain.product.material.Material;
import com.cats.greatCats.domain.product.material.MaterialMapper;
import com.cats.greatCats.business.product.dto.MaterialResponse;
import com.cats.greatCats.infrastructure.exception.BusinessException;
import com.cats.greatCats.util.ImageConverter;
import com.cats.greatCats.validation.Error;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private ProductComponentService productComponentService;

    @Resource
    private ProductComponentMapper productComponentMapper;

    @Resource
    private MaterialMapper materialMapper;

    @Resource
    private ComponentRepository componentRepository;

    @Resource
    private ImageMapper imageMapper;

    @Resource
    private CompanyService companyService;

    @Resource
    private ImageService imageService;


    public List<ActiveProductResponse> getActiveProducts(Integer companyId) {
        List<Product> products = productService.findActiveProductsBy(companyId);
        List<ActiveProductResponse> activeProductRespons = productMapper.toActiveProductResponses(products);
        return activeProductRespons;
    }

    public List<ProductResponse> getProducts(Integer companyId) {
        List<Product> products = productService.findProductsBy(companyId);
        return productMapper.toProductResponse(products);
    }

    public void updateProductStatus(ProductStatusRequest productStatusRequest) {
        Product product = productService.findProductBy(productStatusRequest.getProductId());
        product.setIsActive(productStatusRequest.getProductIsActive());
        productService.saveProduct(product);
    }

    public ProductProfileResponse findProductComponentsAndMaterials(Integer productId) {
        Product product = productService.findProductBy(productId);
        ProductProfileResponse productProfileResponse = productMapper.toProductProfileResponse(product);
        addComponentsToProduct(productId, productProfileResponse);
        return productProfileResponse;
    }

    private void addComponentsToProduct(Integer productId, ProductProfileResponse productProfileResponse) {
        List<ProductComponent> components = productComponentService.findComponentsBy(productId);
        List<ProductComponentResponse> productComponentResponses = productComponentMapper.toProductComponentResponses(components);
        productProfileResponse.setComponentsResponse(productComponentResponses);
        findAndAddMaterialsToComponents(productComponentResponses);
    }

    private void findAndAddMaterialsToComponents(List<ProductComponentResponse> productComponentResponses) {
        for (ProductComponentResponse response : productComponentResponses) {
            Integer componentId = response.getComponentId();
            Optional<Component> componentOptional = componentRepository.findById(componentId);
            if (componentOptional.isPresent()) {
                Component component = componentOptional.get();
                Material material = component.getMaterial();
                if (material != null) {
                    MaterialResponse materialResponse = materialMapper.toMaterialResponse(material);
                    response.setMaterialResponse(materialResponse);
                }

            }

        }
    }

    public void updateProductInfo(ActiveProductResponse productResponse) {
        Product product = productService.findProductBy(productResponse.getProductId());
        product.setName(productResponse.getProductName());
        product.setUpc(productResponse.getProductUpc());
        productService.saveProduct(product);
    }

    public ImageDto findProductImage(Integer productId) {
        Product product = productService.findProductBy(productId);
        return imageMapper.toImageDto(product.getImage());
    }

    @Transactional
    public NewProductResponse addNewProduct(ProductDto productDto) {

        validateUpcCodeIsAvailable(productDto);
        
        String imageData = productDto.getImageData();
        Product productProfile = productMapper.toProductProfile(productDto);

        Company company = companyService.getActiveCompanyBy(productDto.getCompanyId());
        if (company.getId() != null && company.getIsActive().equals(true)) {
            productProfile.setCompany(company);
        }

        if (imageData != null && !imageData.isEmpty()) {
            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            productProfile.setImage(image);
        }
        productService.saveProduct(productProfile);
        NewProductResponse newProductResponse = new NewProductResponse();
        newProductResponse.setProductId(productProfile.getId());
        return newProductResponse;
    }

    private void validateUpcCodeIsAvailable(ProductDto productDto) {
        Product existingProductByUpc = productService.findProductByUpc(productDto.getProductUpc());
        if (existingProductByUpc != null) {
            Error error = Error.UPC_UNAVAILABLE;
            throw new BusinessException(error.getMessage(), error.getErrorCode());
        }
    }
}
