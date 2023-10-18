package com.cats.greatCats.domain;

import com.cats.greatCats.business.product.dto.ProductComponentResponse;
import com.cats.greatCats.domain.product.component.Component;
import com.cats.greatCats.domain.product.component.ProductComponent;
import com.cats.greatCats.domain.product.component.ProductComponentMapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T14:11:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@org.springframework.stereotype.Component
public class ProductComponentMapperImpl implements ProductComponentMapper {

    @Override
    public ProductComponentResponse toProductComponentResponse(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }

        ProductComponentResponse productComponentResponse = new ProductComponentResponse();

        productComponentResponse.setComponentName( productComponentComponentName( productComponent ) );
        productComponentResponse.setComponentId( productComponentComponentId( productComponent ) );

        return productComponentResponse;
    }

    @Override
    public List<ProductComponentResponse> toProductComponentResponses(List<ProductComponent> responseList) {
        if ( responseList == null ) {
            return null;
        }

        List<ProductComponentResponse> list = new ArrayList<ProductComponentResponse>( responseList.size() );
        for ( ProductComponent productComponent : responseList ) {
            list.add( toProductComponentResponse( productComponent ) );
        }

        return list;
    }

    private String productComponentComponentName(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Component component = productComponent.getComponent();
        if ( component == null ) {
            return null;
        }
        String name = component.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Integer productComponentComponentId(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Component component = productComponent.getComponent();
        if ( component == null ) {
            return null;
        }
        Integer id = component.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
