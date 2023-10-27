package com.cats.greatCats.business.recycling;

import com.cats.greatCats.business.recycling.search.SearchService;
import com.cats.greatCats.business.recycling.search.dto.SearchDto;
import com.cats.greatCats.domain.search.Bin;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecyclingController {

    @Resource
    RecyclingService recyclingService;

    @Resource
    SearchService searchService;

    @GetMapping("/bins")
    @Operation(summary = "Returns all bins")
    public List<Bin> getAllBins() {
        return recyclingService.getAllBins();
    }

    @GetMapping("/search/upc")
    @Operation(summary = "Returns recycling instructions by UPC code")
    public SearchDto searchProductAndRecyclingInfo(@RequestParam String productUpc){
        SearchDto searchDto = searchService.searchProductAndRecyclingInfo(productUpc);
        return searchDto;
    }
}
