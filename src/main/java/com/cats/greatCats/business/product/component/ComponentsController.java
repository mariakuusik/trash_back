package com.cats.greatCats.business.product.component;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.domain.product.component.ProductComponentIdResponse;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/components")
public class ComponentsController {

    @Resource
    private ComponentsService componentsService;

    @PostMapping("/component")
    @Operation(summary = "Adds one component to product and material(s) to component")
    public ProductComponentIdResponse addComponentAndMaterialsToProduct(@RequestBody ProductComponentDto productComponentDto) {
        return componentsService.addComponentAndMaterialsToProduct(productComponentDto);
    }

    @GetMapping("")
    @Operation(summary = "Returns all components")
    public List<ComponentResponse> getAllComponents() {
        return componentsService.getAllComponents();
    }

    @DeleteMapping("/component")
    @Operation(summary = "Deletes one component and associated materials")
    public void deleteComponentAndMaterials(@RequestParam Integer productComponentId) {
        componentsService.deleteComponentAndMaterials(productComponentId);
    }
}
