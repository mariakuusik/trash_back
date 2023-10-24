package com.cats.greatCats.business.product.component;

import com.cats.greatCats.domain.product.component.ProductComponent;
import com.cats.greatCats.domain.product.component.ProductComponentRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductComponentService {


    @Resource
    private ProductComponentRepository productComponentRepository;


    public List<ProductComponent> findComponentsBy(Integer productId) {
        return productComponentRepository.findComponentsBy(productId);
    }


    public void saveProductComponent(ProductComponent productComponent) {
        productComponentRepository.save(productComponent);
    }

    public ProductComponent findProductComponentBy(Integer productId, Integer componentId) {
        return productComponentRepository.findProductComponentBy(productId, componentId);
    }
}
