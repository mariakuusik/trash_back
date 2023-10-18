package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.domain.product.Product;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductProfileResponse implements Serializable {
    @NotNull
    @Size(max = 255)
    private String productName;
    @NotNull
    @Size(max = 14)
    private String productUpc;
    @NotNull
    private Boolean productIsActive = false;

    private List<ProductComponentResponse> componentsResponse;
}