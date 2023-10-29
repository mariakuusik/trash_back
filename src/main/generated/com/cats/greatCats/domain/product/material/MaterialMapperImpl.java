package com.cats.greatCats.domain.product.material;

import com.cats.greatCats.business.product.material.MaterialResponse;
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
public class MaterialMapperImpl implements MaterialMapper {

    @Override
    public MaterialResponse toMaterialResponse(Material material) {
        if ( material == null ) {
            return null;
        }

        MaterialResponse materialResponse = new MaterialResponse();

        materialResponse.setMaterialId( material.getId() );
        materialResponse.setMaterialName( material.getName() );
        materialResponse.setMaterialDescription( material.getDescription() );

        return materialResponse;
    }

    @Override
    public List<MaterialResponse> toMaterialResponses(List<Material> materials) {
        if ( materials == null ) {
            return null;
        }

        List<MaterialResponse> list = new ArrayList<MaterialResponse>( materials.size() );
        for ( Material material : materials ) {
            list.add( toMaterialResponse( material ) );
        }

        return list;
    }
}
