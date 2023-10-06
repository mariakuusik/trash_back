package com.cats.greatCats.business;

import com.cats.greatCats.domain.product.material.Material;
import com.cats.greatCats.domain.product.material.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MaterialService {

    private MaterialRepository materialRepository;


    public Optional<Material> findMaterialBy(Integer materialId) {
        Optional<Material> material = materialRepository.findById(materialId);
        return material;
    }
}
