package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.business.product.component.ComponentResponse;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComponentMapper {

    @Mapping(source = "id", target = "componentId")
    @Mapping(source = "name", target = "componentName")
    ComponentResponse toComponentResponse(Component component);
    List<ComponentResponse> toComponentResponses(List<Component> components);

}