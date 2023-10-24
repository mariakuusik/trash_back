package com.cats.greatCats.domain.material;

import com.cats.greatCats.domain.product.material.Material;
import com.cats.greatCats.domain.product.material.MaterialRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    @Resource
    private MaterialRepository materialRepository;


    public Optional<Material> findMaterialBy(Integer materialId) {
        return materialRepository.findById(materialId);
    }

    public List<Material> getAllMaterials() {
        return materialRepository.findAllMaterials();
    }
}
