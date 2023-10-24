package com.cats.greatCats.business.product.recycling;

import com.cats.greatCats.domain.search.Bin;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecyclingController {

    @Resource
    RecyclingService recyclingService;

    @GetMapping("/bins")
    @Operation(summary = "Returns all bins")
    public List<Bin> getAllBins() {
        return recyclingService.getAllBins();
    }
}
