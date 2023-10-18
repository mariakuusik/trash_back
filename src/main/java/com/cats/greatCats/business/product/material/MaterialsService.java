package com.cats.greatCats.business.product.material;

import com.cats.greatCats.business.product.dto.MaterialResponse;
import com.cats.greatCats.domain.material.MaterialService;
import com.cats.greatCats.domain.product.material.Material;
import com.cats.greatCats.domain.product.material.MaterialMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialsService {

    @Resource
    private MaterialService materialService;

    @Resource
    private MaterialMapper materialMapper;

    public List<MaterialResponse> getAllMaterials() {
        List<Material> materials = materialService.getAllMaterials();
        return materialMapper.toMaterialResponses(materials);
    }
}
