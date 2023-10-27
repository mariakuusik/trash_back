package com.cats.greatCats.domain.product.component;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComponentService {

    @Resource
    private ComponentRepository componentRepository;

    public Optional<Component> findComponentBy(Integer componentId) {
        return componentRepository.findById(componentId);
    }
//See ei tööta, sest andmebaasi muudetud:
//    public List<Component> findComponentByMaterial(Integer materialId) {
//        return componentRepository.findByMaterial(materialId);
//
//    }

    public List<Component> findComponentsByProduct(Integer id) {
        return componentRepository.findByProductId(id);
    }

    public List<Component> findComponents() {
        return componentRepository.findAll();
    }
}
