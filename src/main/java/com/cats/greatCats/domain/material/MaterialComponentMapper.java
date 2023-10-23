package com.cats.greatCats.domain.material;

import com.cats.greatCats.business.product.dto.MaterialComponentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialComponentMapper {


    @Mapping(source = "material.name", target = "materialName")
    @Mapping(source = "material.description", target = "materialDescription")
    MaterialComponentResponse toMaterialComponentResponse(MaterialComponent materialComponent);
    List<MaterialComponentResponse> toMaterialComponentResponses(List<MaterialComponent> materialComponents);
}