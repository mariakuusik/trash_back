package com.cats.greatCats.domain.product.image;

import com.cats.greatCats.business.product.dto.ImageDto;
import javax.annotation.processing.Generated;

import com.cats.greatCats.util.ImageConverter;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-17T14:11:15+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class ImageMapperImpl implements ImageMapper {

    @Override
    public ImageDto toImageDto(Image image) {
        if ( image == null ) {
            return null;
        }

        ImageDto imageDto = new ImageDto();

        imageDto.setImageData( ImageConverter.imageToImageData(image) );

        return imageDto;
    }
}
