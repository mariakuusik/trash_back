package com.cats.greatCats.domain.product;

import jakarta.validation.constraints.NotNull;
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
public class ProductResponse implements Serializable {
    private Integer productId;
    private String productName;
    private String productUpc;
    @NotNull
    private Boolean productIsActive = false;
}