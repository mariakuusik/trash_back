package com.cats.greatCats.domain.product;

import com.cats.greatCats.business.product.dto.ProductComponentDto;
import com.cats.greatCats.business.product.dto.ProductComponentIdResponse;
import com.cats.greatCats.business.product.dto.ProductComponentResponse;
import com.cats.greatCats.business.recycling.dto.SearchComponentDto;
import com.cats.greatCats.business.recycling.dto.SearchDto;
import com.cats.greatCats.domain.product.component.Component;
import com.cats.greatCats.domain.recycling.Bin;
import com.cats.greatCats.domain.recycling.Sorting;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-29T12:06:20+0200",
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

    @Override
    public ProductComponentIdResponse toProductComponentIdResponse(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }

        ProductComponentIdResponse productComponentIdResponse = new ProductComponentIdResponse();

        productComponentIdResponse.setProductComponentId( productComponent.getId() );

        return productComponentIdResponse;
    }

    @Override
    public SearchDto toSearchDto(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }

        SearchDto searchDto = new SearchDto();

        searchDto.setProductId( productComponentProductId( productComponent ) );
        searchDto.setProductName( productComponentProductName( productComponent ) );
        searchDto.setProductBinName( productComponentProductBinName( productComponent ) );
        searchDto.setProductBinComments( productComponentProductBinComments( productComponent ) );
        searchDto.setProductSortingInstructions( productComponentProductSortingInstructions( productComponent ) );

        return searchDto;
    }

    @Override
    public SearchComponentDto toSearchComponentDto(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }

        SearchComponentDto searchComponentDto = new SearchComponentDto();

        searchComponentDto.setComponentName( productComponentComponentName( productComponent ) );
        searchComponentDto.setComponentBinName( productComponentComponentBinName( productComponent ) );
        searchComponentDto.setComponentBinComments( productComponentComponentBinComments( productComponent ) );
        searchComponentDto.setComponentSortingInstructions( productComponentComponentSortingInstructions( productComponent ) );

        return searchComponentDto;
    }

    @Override
    public List<SearchComponentDto> toSearchComponentDtos(List<ProductComponent> productComponents) {
        if ( productComponents == null ) {
            return null;
        }

        List<SearchComponentDto> list = new ArrayList<SearchComponentDto>( productComponents.size() );
        for ( ProductComponent productComponent : productComponents ) {
            list.add( toSearchComponentDto( productComponent ) );
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

    private Integer productComponentProductId(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Product product = productComponent.getProduct();
        if ( product == null ) {
            return null;
        }
        Integer id = product.getId();
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

    private String productComponentProductSortingInstructions(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Product product = productComponent.getProduct();
        if ( product == null ) {
            return null;
        }
        Sorting sorting = product.getSorting();
        if ( sorting == null ) {
            return null;
        }
        String instructions = sorting.getInstructions();
        if ( instructions == null ) {
            return null;
        }
        return instructions;
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

    private String productComponentComponentSortingInstructions(ProductComponent productComponent) {
        if ( productComponent == null ) {
            return null;
        }
        Component component = productComponent.getComponent();
        if ( component == null ) {
            return null;
        }
        Sorting sorting = component.getSorting();
        if ( sorting == null ) {
            return null;
        }
        String instructions = sorting.getInstructions();
        if ( instructions == null ) {
            return null;
        }
        return instructions;
    }
}
