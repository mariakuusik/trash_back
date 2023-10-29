package com.cats.greatCats.domain.product;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentIdResponse;
import com.cats.greatCats.business.product.dto.ProductComponentResponse;
import com.cats.greatCats.business.recycling.dto.SearchComponentDto;
import com.cats.greatCats.business.recycling.dto.SearchDto;
import org.mapstruct.*;

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


    @Mapping(source = "id", target = "productComponentId")
    ProductComponentIdResponse toProductComponentIdResponse(ProductComponent productComponent);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "product.bin.name", target = "productBinName")
    @Mapping(source = "product.bin.comments", target = "productBinComments")
    @Mapping(source = "product.sorting.instructions", target = "productSortingInstructions")
    SearchDto toSearchDto(ProductComponent productComponent);

    @Mapping(source = "component.name", target = "componentName")
    @Mapping(source = "component.bin.name", target = "componentBinName")
    @Mapping(source = "component.bin.comments", target = "componentBinComments")
    @Mapping(source = "component.sorting.instructions", target = "componentSortingInstructions")
    SearchComponentDto toSearchComponentDto(ProductComponent productComponent);
    List<SearchComponentDto> toSearchComponentDtos(List<ProductComponent> productComponents);

}