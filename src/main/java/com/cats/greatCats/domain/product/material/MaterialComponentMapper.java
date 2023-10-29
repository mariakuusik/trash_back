package com.cats.greatCats.domain.product.material;

import com.cats.greatCats.business.product.material.dto.MaterialComponentRequest;
import com.cats.greatCats.business.product.material.dto.MaterialComponentResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MaterialComponentMapper {


    @Mapping(source = "material.name", target = "materialName")
    @Mapping(source = "material.description", target = "materialDescription")
    @Mapping(source = "product.id", target = "productId")
    MaterialComponentResponse toMaterialComponentResponse(MaterialComponent materialComponent);

    List<MaterialComponentResponse> toMaterialComponentResponses(List<MaterialComponent> materialComponents);

    @Mapping(source = "materialId", target = "material.id")
    @Mapping(source = "productId", target = "product.id")
    MaterialComponent toMaterialComponent(MaterialComponentRequest materialComponentRequest);
    List<MaterialComponent> toMaterialComponents(List<MaterialComponentRequest> materialComponentRequests);


}