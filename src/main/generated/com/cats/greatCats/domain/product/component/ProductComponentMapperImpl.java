package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentResponse;
import com.cats.greatCats.business.search.dto.SearchResultsByUpc;
import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.search.Bin;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T17:13:45+0300",
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
    public SearchResultsByUpc toSearchResultsByUpc(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }

        SearchResultsByUpc searchResultsByUpc = new SearchResultsByUpc();

        searchResultsByUpc.setProductName( productComponentProductName( productComponent ) );
        searchResultsByUpc.setComponentId( productComponentComponentId( productComponent ) );
        searchResultsByUpc.setComponentName( productComponentComponentName( productComponent ) );
        searchResultsByUpc.setProductBinName( productComponentProductBinName( productComponent ) );
        searchResultsByUpc.setProductBinComments( productComponentProductBinComments( productComponent ) );
        searchResultsByUpc.setComponentBinName( productComponentComponentBinName( productComponent ) );
        searchResultsByUpc.setComponentBinComments( productComponentComponentBinComments( productComponent ) );

        return searchResultsByUpc;
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

    private String productComponentProductName(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Product product = productComponent.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productComponentProductBinName(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Product product = productComponent.getProduct();
        if ( product == null ) {
            return null;
        }
        Bin bin = product.getBin();
        if ( bin == null ) {
            return null;
        }
        String name = bin.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productComponentProductBinComments(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Product product = productComponent.getProduct();
        if ( product == null ) {
            return null;
        }
        Bin bin = product.getBin();
        if ( bin == null ) {
            return null;
        }
        String comments = bin.getComments();
        if ( comments == null ) {
            return null;
        }
        return comments;
    }

    private String productComponentComponentBinName(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Component component = productComponent.getComponent();
        if ( component == null ) {
            return null;
        }
        Bin bin = component.getBin();
        if ( bin == null ) {
            return null;
        }
        String name = bin.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String productComponentComponentBinComments(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Component component = productComponent.getComponent();
        if ( component == null ) {
            return null;
        }
        Bin bin = component.getBin();
        if ( bin == null ) {
            return null;
        }
        String comments = bin.getComments();
        if ( comments == null ) {
            return null;
        }
        return comments;
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
