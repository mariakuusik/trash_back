package com.cats.greatCats.business.product;

import com.cats.greatCats.business.ProductsService;
import com.cats.greatCats.domain.product.ProductResponse;
import com.cats.greatCats.infrastructure.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;

    @GetMapping("/product")
    @Operation(summary = "Tagastab companyId järgi ettevõtte aktiivsed tooted")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi toodet",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public List<ProductResponse> getProducts(@RequestParam Integer companyId) {
        return productsService.getProducts(companyId);

    }
}
