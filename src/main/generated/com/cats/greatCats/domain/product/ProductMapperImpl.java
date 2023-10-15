package com.cats.greatCats.domain.product;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T21:11:27+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ActiveProductResponse toActiveProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ActiveProductResponse activeProductResponse = new ActiveProductResponse();

        activeProductResponse.setProductId( product.getId() );
        activeProductResponse.setProductName( product.getName() );
        activeProductResponse.setProductUpc( product.getUpc() );

        return activeProductResponse;
    }

    @Override
    public List<ActiveProductResponse> toActiveProductResponses(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ActiveProductResponse> list = new ArrayList<ActiveProductResponse>( products.size() );
        for ( Product product : products ) {
            list.add( toActiveProductResponse( product ) );
        }

        return list;
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductResponse productResponse = new ProductResponse();

        productResponse.setProductId( product.getId() );
        productResponse.setProductName( product.getName() );
        productResponse.setProductUpc( product.getUpc() );
        productResponse.setProductIsActive( product.getIsActive() );

        return productResponse;
    }

    @Override
    public List<ProductResponse> toProductResponse(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductResponse> list = new ArrayList<ProductResponse>( products.size() );
        for ( Product product : products ) {
            list.add( toProductResponse( product ) );
        }

        return list;
    }

    @Override
    public ProductProfileResponse toProductProfileResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductProfileResponse productProfileResponse = new ProductProfileResponse();

        productProfileResponse.setProductName( product.getName() );
        productProfileResponse.setProductUpc( product.getUpc() );
        productProfileResponse.setProductIsActive( product.getIsActive() );

        return productProfileResponse;
    }
}
