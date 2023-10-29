package com.cats.greatCats.domain.product.material;

import com.cats.greatCats.business.product.material.dto.MaterialComponentRequest;
import com.cats.greatCats.business.product.material.dto.MaterialComponentResponse;
import com.cats.greatCats.domain.product.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-29T12:06:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class MaterialComponentMapperImpl implements MaterialComponentMapper {

    @Override
    public MaterialComponentResponse toMaterialComponentResponse(MaterialComponent materialComponent) {
        if ( materialComponent == null ) {
            return null;
        }

        MaterialComponentResponse materialComponentResponse = new MaterialComponentResponse();

        materialComponentResponse.setMaterialName( materialComponentMaterialName( materialComponent ) );
        materialComponentResponse.setMaterialDescription( materialComponentMaterialDescription( materialComponent ) );
        materialComponentResponse.setProductId( materialComponentProductId( materialComponent ) );

        return materialComponentResponse;
    }

    @Override
    public List<MaterialComponentResponse> toMaterialComponentResponses(List<MaterialComponent> materialComponents) {
        if ( materialComponents == null ) {
            return null;
        }

        List<MaterialComponentResponse> list = new ArrayList<MaterialComponentResponse>( materialComponents.size() );
        for ( MaterialComponent materialComponent : materialComponents ) {
            list.add( toMaterialComponentResponse( materialComponent ) );
        }

        return list;
    }

    @Override
    public MaterialComponent toMaterialComponent(MaterialComponentRequest materialComponentRequest) {
        if ( materialComponentRequest == null ) {
            return null;
        }

        MaterialComponent materialComponent = new MaterialComponent();

        materialComponent.setMaterial( materialComponentRequestToMaterial( materialComponentRequest ) );
        materialComponent.setProduct( materialComponentRequestToProduct( materialComponentRequest ) );

        return materialComponent;
    }

    @Override
    public List<MaterialComponent> toMaterialComponents(List<MaterialComponentRequest> materialComponentRequests) {
        if ( materialComponentRequests == null ) {
            return null;
        }

        List<MaterialComponent> list = new ArrayList<MaterialComponent>( materialComponentRequests.size() );
        for ( MaterialComponentRequest materialComponentRequest : materialComponentRequests ) {
            list.add( toMaterialComponent( materialComponentRequest ) );
        }

        return list;
    }

    private String materialComponentMaterialName(MaterialComponent materialComponent) {
        if ( materialComponent == null ) {
            return null;
        }
        Material material = materialComponent.getMaterial();
        if ( material == null ) {
            return null;
        }
        String name = material.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private String materialComponentMaterialDescription(MaterialComponent materialComponent) {
        if ( materialComponent == null ) {
            return null;
        }
        Material material = materialComponent.getMaterial();
        if ( material == null ) {
            return null;
        }
        String description = material.getDescription();
        if ( description == null ) {
            return null;
        }
        return description;
    }

    private Integer materialComponentProductId(MaterialComponent materialComponent) {
        if ( materialComponent == null ) {
            return null;
        }
        Product product = materialComponent.getProduct();
        if ( product == null ) {
            return null;
        }
        Integer id = product.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Material materialComponentRequestToMaterial(MaterialComponentRequest materialComponentRequest) {
        if ( materialComponentRequest == null ) {
            return null;
        }

        Material material = new Material();

        material.setId( materialComponentRequest.getMaterialId() );

        return material;
    }

    protected Product materialComponentRequestToProduct(MaterialComponentRequest materialComponentRequest) {
        if ( materialComponentRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setId( materialComponentRequest.getProductId() );

        return product;
    }
}
