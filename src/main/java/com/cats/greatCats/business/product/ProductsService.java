package com.cats.greatCats.business.product;

import com.cats.greatCats.Sorting;
import com.cats.greatCats.business.product.component.ProductComponentService;
import com.cats.greatCats.business.product.dto.*;
import com.cats.greatCats.domain.company.Company;
import com.cats.greatCats.domain.company.CompanyService;
import com.cats.greatCats.domain.material.MaterialComponent;
import com.cats.greatCats.domain.material.MaterialComponentMapper;
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
import com.cats.greatCats.domain.product.material.MaterialMapper;
import com.cats.greatCats.domain.search.Bin;
import com.cats.greatCats.infrastructure.exception.BusinessException;
import com.cats.greatCats.util.ImageConverter;
import com.cats.greatCats.validation.Error;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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

    @Resource
    private MaterialComponentMapper materialComponentMapper;

    @Resource
    private BinService binService;

    @Resource
    private SortingService sortingService;


    public List<ActiveProductResponse> getActiveProducts(Integer companyId) {
        List<Product> products = productService.findActiveProductsBy(companyId);
        return productMapper.toActiveProductResponses(products);
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

        List<ProductComponent> components = productComponentService.findComponentsBy(productId);
        List<ProductComponentResponse> productComponentResponses = productComponentMapper.toProductComponentResponses(components);

        productProfileResponse.setComponentsResponse(productComponentResponses);

        for (ProductComponentResponse componentResponse : productComponentResponses) {
            Integer componentId = componentResponse.getComponentId();
            Optional<Component> componentOptional = componentRepository.findById(componentId);
            if (componentOptional.isPresent()) {
                Component component = componentOptional.get();
                Set<MaterialComponent> materialComponents = component.getMaterialComponents();
                List<MaterialComponent> materialComponentList = new ArrayList<>(materialComponents); // Convert Set to List

                List<MaterialComponentResponse> materialComponentResponseList = materialComponentMapper.toMaterialComponentResponses(materialComponentList);
                componentResponse.setMaterialComponentResponse(materialComponentResponseList);
            }


        }
        return productProfileResponse;
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
        AddImageIdIfPresent(imageData, productProfile);
        addBinIdIfPresent(productDto, productProfile);
        addSortingIdIfPresent(productDto, productProfile);

        productService.saveProduct(productProfile);
        NewProductResponse newProductResponse = new NewProductResponse();
        newProductResponse.setProductId(productProfile.getId());
        return newProductResponse;
    }

    private void AddImageIdIfPresent(String imageData, Product productProfile) {
        if (imageData != null && !imageData.isEmpty()) {
            Image image = ImageConverter.imageDataToImage(imageData);
            imageService.saveImage(image);
            productProfile.setImage(image);
        }
    }

    private void addSortingIdIfPresent(ProductDto productDto, Product productProfile) {
        if (productDto.getSortingId() != null) {
            Optional<Sorting> sortingOptional = sortingService.getSortingId(productDto.getSortingId());
            sortingOptional.ifPresent(productProfile::setSorting);
        }
    }
    //TODO: kas sorting peaks olema nii, et lisad ise mingi teksti (ja siis andmebaasi uus rida).

    private void addBinIdIfPresent(ProductDto productDto, Product productProfile) {
        if (productDto.getBinId() != null) {
            Optional<Bin> binOptional = binService.getBinId(productDto.getBinId());
            binOptional.ifPresent(productProfile::setBin);
        }
    }

    private void validateUpcCodeIsAvailable(ProductDto productDto) {
        Product existingProductByUpc = productService.findProductByUpc(productDto.getProductUpc());
        if (existingProductByUpc != null) {
            Error error = Error.UPC_UNAVAILABLE;
            throw new BusinessException(error.getMessage(), error.getErrorCode());
        }
    }
}
