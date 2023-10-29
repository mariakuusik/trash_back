package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.business.product.component.dto.ComponentResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T17:50:59+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@org.springframework.stereotype.Component
public class ComponentMapperImpl implements ComponentMapper {

    @Override
    public ComponentResponse toComponentResponse(Component component) {
        if ( component == null ) {
            return null;
        }

        ComponentResponse componentResponse = new ComponentResponse();

        componentResponse.setComponentId( component.getId() );
        componentResponse.setComponentName( component.getName() );

        return componentResponse;
    }

    @Override
    public List<ComponentResponse> toComponentResponses(List<Component> components) {
        if ( components == null ) {
            return null;
        }

        List<ComponentResponse> list = new ArrayList<ComponentResponse>( components.size() );
        for ( Component component : components ) {
            list.add( toComponentResponse( component ) );
        }

        return list;
    }
}
