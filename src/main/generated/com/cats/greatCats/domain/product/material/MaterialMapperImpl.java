package com.cats.greatCats.domain.product.material;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-05T22:40:01+0300",
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

        materialResponse.setMaterialName( material.getName() );
        materialResponse.setMaterialDescription( material.getDescription() );

        return materialResponse;
    }
}
