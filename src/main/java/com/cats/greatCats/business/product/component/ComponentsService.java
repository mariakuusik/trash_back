package com.cats.greatCats.business.product.component;

import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.ProductService;
import com.cats.greatCats.domain.product.component.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ComponentsService {

    @Resource
    private ProductService productService;

    @Resource
    private ComponentService componentService;

    @Resource
    private ProductComponentMapper productComponentMapper;

    @Resource
    private ProductComponentService productComponentService;

    @Resource
    private ComponentMapper componentMapper;

    public void addComponentsAndMaterialsToProduct(ProductComponentDto productComponentDto) {
        productComponentMapper.toProductComponent(productComponentDto)

        Product product = productService.findProductBy(productComponentDto.getProductId());
        Optional<Component> componentOptional = componentService.findComponentBy(productComponentDto.getComponentId());
        if (componentOptional.isPresent()) {
            Component component = componentOptional.get();
            ProductComponent productComponent = new ProductComponent();
            productComponent.setProduct(product);
            productComponent.setComponent(component);
            productComponentService.saveProductComponent(productComponent);
        }
    }
//See ei tööta, sest andmebaasi muudetud:
//    public List<ComponentResponse> getComponentsBy(Integer materialId) {
//        List<Component> components = componentService.findComponentByMaterial(materialId);
//        return componentMapper.toComponentResponses(components);
//
//
//    }
}
