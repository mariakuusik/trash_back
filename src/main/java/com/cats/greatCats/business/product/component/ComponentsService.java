package com.cats.greatCats.business.product.component;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.domain.material.MaterialComponent;
import com.cats.greatCats.domain.material.MaterialComponentMapper;
import com.cats.greatCats.domain.material.MaterialComponentRequest;
import com.cats.greatCats.domain.material.MaterialService;
import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.ProductService;
import com.cats.greatCats.domain.product.component.*;
import com.cats.greatCats.domain.product.material.Material;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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


    @Transactional
    public void addComponentsAndMaterialsToProduct(ProductComponentDto productComponentDto) {
        ProductComponent productComponent = productComponentMapper.toProductComponent(productComponentDto);
        Component component = productComponent.getComponent();
        component.setId(productComponentDto.getComponentId());
        Product product = productComponent.getProduct();
        product.setId(productComponentDto.getProductId());

        List<MaterialComponentRequest> materials = productComponentDto.getMaterials();
        List<MaterialComponent> materialComponents = new ArrayList<>();

        for (MaterialComponentRequest materialComponentRequest : materials) {
            Integer materialId = materialComponentRequest.getMaterialId();
            Optional<Material> materialOptional = materialService.findMaterialBy(materialId);
            if (materialOptional.isPresent()) {
                MaterialComponent materialComponent = materialComponentMapper.toMaterialComponent(materialComponentRequest);
                materialComponent.setMaterial(materialOptional.get());
                materialComponents.add(materialComponent);
            }
        }

        component.setMaterialComponents(new HashSet<>(materialComponents));
        productComponentService.saveProductComponent(productComponent);
        materialComponentService.saveComponentMaterials(materialComponents);

    }


}
