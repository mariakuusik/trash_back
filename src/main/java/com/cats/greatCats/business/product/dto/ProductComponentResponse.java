package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.domain.product.component.ProductComponent;
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
public class ProductComponentResponse implements Serializable {
    private Integer componentId;
    private String componentName;
    private MaterialResponse materialResponse;
}