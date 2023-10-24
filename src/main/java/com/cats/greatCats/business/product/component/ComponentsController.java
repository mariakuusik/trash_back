package com.cats.greatCats.business.product.component;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/components")
public class ComponentsController {

    @Resource
    private ComponentsService componentsService;

    @PostMapping("/component")
    @Operation(summary = "Adds one component to product")
    public void addComponentsAndMaterialsToProduct(@RequestBody ProductComponentDto productComponentDto){
        componentsService.addComponentsAndMaterialsToProduct(productComponentDto);
    }
}
