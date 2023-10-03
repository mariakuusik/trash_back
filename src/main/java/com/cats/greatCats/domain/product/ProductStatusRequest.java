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
public class ProductStatusRequest implements Serializable {
    private Integer productId;
    @NotNull
    private Boolean productIsActive = false;
}