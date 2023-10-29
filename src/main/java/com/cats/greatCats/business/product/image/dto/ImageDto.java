package com.cats.greatCats.business.product.image.dto;

import com.cats.greatCats.domain.product.image.Image;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Image}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto implements Serializable {
    @NotNull
    private String imageData;
}