package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentResponse;
import com.cats.greatCats.business.search.dto.SearchResultsByUpc;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductComponentMapper {

    @Mapping(source = "component.name", target = "componentName")
    @Mapping(source = "component.id", target = "componentId")
    ProductComponentResponse toProductComponentResponse(ProductComponent productComponent);

    List<ProductComponentResponse> toProductComponentResponses(List<ProductComponent> responseList);


    //Choose if bin is connected to PRODUCT or COMPONENT
    @Mapping(source = "product.name", target = "productName")
    @Mapping(source = "component.id", target = "componentId")
    @Mapping(source = "component.name", target = "componentName")
    @Mapping(source = "product.bin.name", target = "productBinName")
    @Mapping(source = "product.bin.comments", target = "productBinComments")
    @Mapping(source = "component.bin.name", target = "componentBinName")
    @Mapping(source = "component.bin.comments", target = "componentBinComments")
    SearchResultsByUpc toSearchResultsByUpc(ProductComponent productComponent);



    @Mapping(source = "componentId", target = "component.id")
    @Mapping(source = "productId", target = "product.id")
    ProductComponent toProductComponent(ProductComponentDto productComponentDto);

}