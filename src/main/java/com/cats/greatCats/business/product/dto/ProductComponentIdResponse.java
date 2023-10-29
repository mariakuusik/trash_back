package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.domain.product.ProductComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ProductComponent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComponentIdResponse implements Serializable {
    private Integer productComponentId;
}