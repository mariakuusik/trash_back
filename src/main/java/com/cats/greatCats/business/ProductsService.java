package com.cats.greatCats.business;

import com.cats.greatCats.domain.ProductComponent;
import com.cats.greatCats.domain.ProductComponentMapper;
import com.cats.greatCats.domain.ProductComponentResponse;
import com.cats.greatCats.domain.product.*;
import com.cats.greatCats.domain.product.component.Component;
import com.cats.greatCats.domain.product.component.ComponentRepository;
import com.cats.greatCats.domain.product.material.Material;
import com.cats.greatCats.domain.product.material.MaterialMapper;
import com.cats.greatCats.domain.product.material.MaterialResponse;
import jakarta.annotation.Resource;
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
                if (material !=null){
                    MaterialResponse materialResponse = materialMapper.toMaterialResponse(material);
                    response.setMaterialResponse(materialResponse);
                }

            }

        }
    }
}
