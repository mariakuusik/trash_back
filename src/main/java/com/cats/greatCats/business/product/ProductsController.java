package com.cats.greatCats.business.product;

import com.cats.greatCats.business.product.dto.*;
import com.cats.greatCats.infrastructure.error.ApiError;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Resource
    private ProductsService productsService;


    @GetMapping("/active")
    @Operation(summary = "Tagastab companyId järgi ettevõtte aktiivsed tooted",
            description = "Tagastatakse ainult aktiivsed tooted")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Ei leitud ühtegi aktiivset toodet",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})

    public List<ActiveProductResponse> getActiveProducts(@RequestParam Integer companyId) {
        return productsService.getActiveProducts(companyId);
    }

    @GetMapping("")
    @Operation(summary = "Returns all products associated with companyId",
            description = "Returns both active and inactive products")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "No products were found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public List<ProductResponse> getProducts(@RequestParam Integer companyId) {
        return productsService.getProducts(companyId);
    }

    @PatchMapping("/status")
    @Operation(summary = "Changes product to active/inactive",
            description = "Changes Boolean productIsActive")
    public void changeStatus(@RequestBody ProductStatusRequest productStatusRequest) {
        productsService.updateProductStatus(productStatusRequest);
    }

    @GetMapping("/profile")
    @Operation(summary = "Returns product profile with all associated components and materials")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "No components were found",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public ProductProfileResponse findProductComponentsAndMaterials(@RequestParam Integer productId) {
        return productsService.findProductComponentsAndMaterials(productId);
    }

    @PutMapping("/profile")
    @Operation(summary = "Changes productName and UPC")
    public void updateProductInfo(@RequestBody ActiveProductResponse productResponse) {
        productsService.updateProductInfo(productResponse);
    }

    @PostMapping("/profile")
    @Operation(summary = "Adds new product to the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Product not added",
                    content = @Content(schema = @Schema(implementation = ApiError.class)))})
    public NewProductResponse addNewProduct(@RequestBody ProductDto productDto) {
        return productsService.addNewProduct(productDto);
    }

}
