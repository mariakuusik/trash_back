package com.cats.greatCats.business.product.image;


import com.cats.greatCats.business.product.ProductsService;
import com.cats.greatCats.business.product.dto.ImageDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class ImagesController {

    @Resource
    private ImagesService imagesService;

    @Resource
    private ProductsService productsService;

    @PostMapping("/image")
    @Operation(summary = "Adds image to the database",
            description = "Adding images to DB is an admin feature")
    public void addImage(@RequestBody ImageDto imageDto) {
        imagesService.addImage(imageDto);
    }

    @GetMapping("/image")
    @Operation(summary = "Returns image associated with product")
    public ImageDto findProductImage(@RequestParam Integer productId){
        return productsService.findProductImage(productId);
    }

}
