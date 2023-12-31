package com.cats.greatCats.domain.product.material;

import com.cats.greatCats.business.product.material.MaterialResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialMapper {


  @Mapping(source = "id", target = "materialId")
  @Mapping(source = "name", target = "materialName")
  @Mapping(source = "description", target = "materialDescription")
  MaterialResponse toMaterialResponse(Material material);
  List <MaterialResponse> toMaterialResponses(List<Material>materials);


}