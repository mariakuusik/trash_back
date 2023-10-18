package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.domain.product.Product;
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
public class NewProductResponse implements Serializable {
    private Integer productId;
}