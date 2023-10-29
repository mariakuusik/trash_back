package com.cats.greatCats.domain.product.image;

import com.cats.greatCats.business.product.image.dto.ImageDto;
import com.cats.greatCats.util.ImageConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING,
imports = {ImageConverter.class, Image.class})
public interface ImageMapper {

    @Mapping(expression= "java(ImageConverter.imageToImageData(image))", target = "imageData")
    ImageDto toImageDto(Image image);





}