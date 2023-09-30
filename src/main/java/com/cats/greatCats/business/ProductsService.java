package com.cats.greatCats.business;

import com.cats.greatCats.domain.product.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;

    @Resource
    private  ProductComponentMaterialService productComponentMaterialService;

    @Resource
    private ProductComponentMaterialMapper productComponentMaterialMapper;


    public List<ProductResponse> getProducts(Integer companyId) {
        List<Product> products = productService.findActiveProductsBy(companyId);
        List<ProductResponse> productResponses = productMapper.toProductResponses(products);


        for(ProductResponse product : productResponses){
            List<ProductComponentMaterial> componentsAndMaterials = productComponentMaterialService.
                    findComponentsAndMaterialsBy(product.getProductId());
            List<ProductComponentMaterialDto> productComponentMaterials = new ArrayList<>();
            for(ProductComponentMaterial componentMaterial : componentsAndMaterials){
                ProductComponentMaterialDto dto = productComponentMaterialMapper.toProductComponentMaterialDto(componentMaterial);
                productComponentMaterials.add(dto);
            }
            product.setComponentsAndMaterials(productComponentMaterials);
        }

        return productResponses;
    }
}
