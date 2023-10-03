package com.cats.greatCats.domain.product;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    //Productite tagastuseks listina, ainult aktiivsed
    //kõigepealt mapid ära mida vaja ja siis kasutad seda tulemust Listis.

    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "upc", target = "productUpc")
    ActiveProductResponse toActiveProductResponse(Product product);
    List<ActiveProductResponse> toActiveProductResponses(List<Product> products);

    //Productite tagastus KÕIK - nii aktiivsed kui mitteaktiivsed.
    @Mapping(source = "id", target = "productId")
    @Mapping(source = "name", target = "productName")
    @Mapping(source = "upc", target = "productUpc")
    @Mapping(source = "isActive", target = "productIsActive")
    ProductResponse toProductResponse(Product product);
    List<ProductResponse> toProductResponse(List<Product> products);
}