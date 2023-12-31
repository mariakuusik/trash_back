package com.cats.greatCats.business.product.component;

import com.cats.greatCats.business.product.component.dto.ComponentResponse;
import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentIdResponse;
import com.cats.greatCats.domain.product.*;
import com.cats.greatCats.domain.product.material.*;
import com.cats.greatCats.business.product.material.dto.MaterialComponentRequest;
import com.cats.greatCats.domain.product.component.*;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    private MaterialComponentService materialComponentService;

    @Resource
    private MaterialComponentMapper materialComponentMapper;

    @Resource
    private MaterialService materialService;

    @Resource
    private ComponentMapper componentMapper;


    @Transactional
    public ProductComponentIdResponse addComponentAndMaterialsToProduct(ProductComponentDto productComponentDto) {
        ProductComponent productComponent = productComponentMapper.toProductComponent(productComponentDto);
        ProductComponent existingProductComponent = productComponentService.findProductComponentBy(productComponentDto.getProductId(), productComponentDto.getComponentId());

        if (existingProductComponent != null) {
            productComponent = existingProductComponent;
        } else {
            Component component = productComponent.getComponent();
            component.setId(productComponentDto.getComponentId());
            Product product = productComponent.getProduct();
            product.setId(productComponentDto.getProductId());
        }
        List<MaterialComponentRequest> materials = productComponentDto.getMaterials();
        List<MaterialComponent> materialComponents = new ArrayList<>();


        for (MaterialComponentRequest materialComponentRequest : materials) {
            Integer materialId = materialComponentRequest.getMaterialId();
            Optional<Material> materialOptional = materialService.findMaterialBy(materialId);
            if (materialOptional.isPresent()) {
                MaterialComponent materialComponent = materialComponentMapper.toMaterialComponent(materialComponentRequest);

                materialComponent.setComponent(productComponent.getComponent());
                materialComponent.setMaterial(materialOptional.get());
                materialComponent.setProduct(productComponent.getProduct());


                materialComponents.add(materialComponent);
            }
        }

        materialComponentService.saveComponentMaterials(materialComponents);
        productComponentService.saveProductComponent(productComponent);

        ProductComponentIdResponse productComponentIdResponse = productComponentMapper.toProductComponentIdResponse(productComponent);
        return productComponentIdResponse;
    }

    public List<ComponentResponse> getAllComponents() {
        List<Component> components = componentService.findComponents();
        return componentMapper.toComponentResponses(components);
    }

    public void deleteComponentAndMaterials(Integer productComponentId) {
        Component componentId = productComponentService.findComponentIdBy(productComponentId);
        materialComponentService.deleteComponentMaterialsBy(componentId);
        productComponentService.findProductComponentBy(productComponentId);


    }
}
