package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.domain.product.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {
    private Integer companyId;
    @NotNull
    @Size(max = 255)
    private String productName;
    @NotNull
    @Size(max = 14)
    private String productUpc;
    @NotNull
    private Boolean productIsActive = false;
    private String imageData;
    private Integer binId;
    private Integer sortingId;
}