package com.cats.greatCats.business.product.component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.cats.greatCats.domain.product.component.ProductComponent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComponentDto implements Serializable {
    private Integer productId;
    private Integer componentId;
}