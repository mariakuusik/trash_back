package com.cats.greatCats.business.product.component;

import com.cats.greatCats.domain.product.component.Component;
import com.cats.greatCats.domain.product.component.ComponentRepository;
import com.cats.greatCats.domain.product.component.ProductComponent;
import com.cats.greatCats.domain.product.component.ProductComponentRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductComponentService {


    @Resource
    private ProductComponentRepository productComponentRepository;

    @Resource
    private ComponentRepository componentRepository;


    public List<ProductComponent> findComponentsBy(Integer productId) {
        return productComponentRepository.findComponentsBy(productId);
    }


    public void saveProductComponent(ProductComponent productComponent) {
        productComponentRepository.save(productComponent);
    }

    public ProductComponent findProductComponentBy(Integer productId, Integer componentId) {
        return productComponentRepository.findProductComponentBy(productId, componentId);
    }

    public void findProductComponentBy(Integer productComponentId) {
        productComponentRepository.deleteById(productComponentId);
    }

    public Component findComponentIdBy(Integer productComponentId) {
        return componentRepository.findByProductComponentId(productComponentId);
    }


    public List<ProductComponent> findProductBy(Integer productId) {
        return productComponentRepository.findProductsBy(productId);
    }


}
