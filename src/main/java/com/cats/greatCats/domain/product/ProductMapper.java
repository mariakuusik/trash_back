package com.cats.greatCats.domain.product;

import com.cats.greatCats.business.product.dto.ActiveProductResponse;
import com.cats.greatCats.business.product.dto.ProductDto;
import com.cats.greatCats.business.product.dto.ProductProfileResponse;
import com.cats.greatCats.business.product.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

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

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "upc", target = "productUpc")
    @Mapping(source = "isActive", target = "productIsActive")
    ProductProfileResponse toProductProfileResponse(Product product);

    @Mapping(source = "productIsActive", target = "isActive")
    @Mapping(source = "productUpc", target = "upc")
    @Mapping(source = "productName", target = "name")
    @Mapping(source = "companyId", target = "company.id")
    Product toProductProfile(ProductDto productDto);




}