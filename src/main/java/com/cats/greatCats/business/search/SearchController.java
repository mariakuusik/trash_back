package com.cats.greatCats.business.search;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {
    @Resource
    private SearchService searchService;
    @GetMapping("/search/upc")
    @Operation(summary = "Returns recycling instructions by UPC code")
    public void searchProductAndRecyclingInfo(@RequestParam String productUpc){
        searchService.searchProductAndRecyclingInfo(productUpc);
    }
}
