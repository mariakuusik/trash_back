package com.cats.greatCats.domain.product.material;

import com.cats.greatCats.domain.product.material.MaterialComponent;
import com.cats.greatCats.domain.product.material.MaterialComponentRepository;
import com.cats.greatCats.domain.product.component.Component;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialComponentService {

    @Resource
    private  MaterialComponentRepository materialComponentRepository;


    public void saveComponentMaterials(List<MaterialComponent> materialComponents) {
        materialComponentRepository.saveAll(materialComponents);
    }

    public void deleteComponentMaterialsBy(Component componentId) {
        materialComponentRepository.deleteByComponent(componentId);
    }

    public List<MaterialComponent> findComponentMaterialsBy(Integer componentId) {
        return materialComponentRepository.findComponentMaterialsBy(componentId);
    }
}
