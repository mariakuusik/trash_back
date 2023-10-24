package com.cats.greatCats.business.product.component;

import com.cats.greatCats.domain.material.MaterialComponent;
import com.cats.greatCats.domain.material.MaterialComponentRepository;
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
}
