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

    public List<Component> findComponentByMaterial(Integer materialId) {
        return componentRepository.findByMaterial(materialId);

    }
}
