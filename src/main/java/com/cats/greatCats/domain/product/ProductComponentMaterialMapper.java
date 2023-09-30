package com.cats.greatCats.domain.product;

import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductComponentMaterialMapper {
    @Mapping(source = "component.id", target = "productComponentId")
    @Mapping(source = "component.name", target = "productComponentName")
    @Mapping(source = "material.id", target = "productMaterialId")
    @Mapping(source = "material.name", target = "productMaterialName")
    @Mapping(source = "material.description", target = "productMaterialDescription")
    ProductComponentMaterialDto toProductComponentMaterialDto(ProductComponentMaterial productComponentMaterial);

}