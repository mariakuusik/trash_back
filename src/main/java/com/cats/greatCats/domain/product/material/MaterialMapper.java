package com.cats.greatCats.domain.product.material;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialMapper {


  @Mapping(source = "name", target = "materialName")
  @Mapping(source = "description", target = "materialDescription")
    MaterialResponse toMaterialResponse(Material material);


}