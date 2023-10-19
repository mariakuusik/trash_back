package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.business.product.component.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentResponse;
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

    List<ProductComponentResponse> toProductComponentResponses(List<ProductComponent> responseList);


    @Mapping(source = "componentId", target = "component.id")
    @Mapping(source = "productId", target = "product.id")
    ProductComponent toProductComponent(ProductComponentDto productComponentDto);


}