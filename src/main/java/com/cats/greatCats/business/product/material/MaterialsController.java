package com.cats.greatCats.business.product.material;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materials")
public class MaterialsController {

    @Resource
    private MaterialsService materialsService;

    @GetMapping("")
    @Operation(summary = "Returns all materials")
    public List<MaterialResponse> getAllMaterials() {
        return materialsService.getAllMaterials();
    }
}
