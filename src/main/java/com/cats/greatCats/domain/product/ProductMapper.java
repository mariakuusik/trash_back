package com.cats.greatCats.domain.product;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    //Productite tagastuseks listina.
    //kõigepealt mapid ära mida vaja ja siis kasutad seda tulemust Listis.

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "upc", target = "productUpc")
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponses(List<Product>products);



}