package com.cats.greatCats.domain.material;

import com.cats.greatCats.business.product.dto.MaterialComponentResponse;
import com.cats.greatCats.domain.product.material.Material;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-23T16:23:09+0300",
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

        return materialComponent;
    }

    @Override
    public List<MaterialComponent> tomaterialComponents(List<MaterialComponentRequest> materialComponentRequests) {
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

    protected Material materialComponentRequestToMaterial(MaterialComponentRequest materialComponentRequest) {
        if ( materialComponentRequest == null ) {
            return null;
        }

        Material material = new Material();

        material.setId( materialComponentRequest.getMaterialId() );

        return material;
    }
}
