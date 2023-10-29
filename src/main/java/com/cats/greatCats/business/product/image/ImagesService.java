package com.cats.greatCats.business.product.image;

import com.cats.greatCats.business.product.image.dto.ImageDto;
import com.cats.greatCats.domain.product.image.Image;
import com.cats.greatCats.util.ImageConverter;
import com.cats.greatCats.domain.product.image.ImageRepository;
import com.cats.greatCats.domain.product.image.ImageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class ImagesService {

    @Resource
    private ImageService imageService;
    private final ImageRepository imageRepository;

    public ImagesService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    public void addImage(ImageDto imageDto) {
        String imageData = imageDto.getImageData();
        Image image = ImageConverter.imageDataToImage(imageData);
        imageService.saveImage(image);

    }

    public void findProductImage(Integer productId) {

    }
}
