package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.business.product.component.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentResponse;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-19T17:50:59+0300",
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

    @Override
    public ProductComponent toProductComponent(ProductComponentDto productComponentDto) {
        if ( productComponentDto == null ) {
            return null;
        }

        ProductComponent productComponent = new ProductComponent();

        productComponent.setComponent( productComponentDtoToComponent( productComponentDto ) );
        productComponent.setProduct( productComponentDtoToProduct( productComponentDto ) );

        return productComponent;
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

    protected Component productComponentDtoToComponent(ProductComponentDto productComponentDto) {
        if ( productComponentDto == null ) {
            return null;
        }

        Component component = new Component();

        component.setId( productComponentDto.getComponentId() );

        return component;
    }

    protected Product productComponentDtoToProduct(ProductComponentDto productComponentDto) {
        if ( productComponentDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( productComponentDto.getProductId() );

        return product;
    }
}
