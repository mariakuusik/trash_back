package com.cats.greatCats.domain;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductComponentMapper {

    @Mapping(source = "component.name", target = "componentName")
    @Mapping(source = "component.id", target = "componentId")

    ProductComponentResponse toProductComponentResponse(ProductComponent productComponent);
    List <ProductComponentResponse> toProductComponentResponses(List<ProductComponent> responseList);

}