package com.cats.greatCats.business;

import com.cats.greatCats.domain.product.ProductComponentMaterial;
import com.cats.greatCats.domain.product.ProductComponentMaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductComponentMaterialService {

    private final ProductComponentMaterialRepository productComponentMaterialRepository;

    public ProductComponentMaterialService(ProductComponentMaterialRepository productComponentMaterialRepository) {
        this.productComponentMaterialRepository = productComponentMaterialRepository;
    }


    public List<ProductComponentMaterial> findComponentsAndMaterialsBy(Integer productId) {
        return productComponentMaterialRepository.findComponentsAndMaterialsBy(productId);
    }
}
