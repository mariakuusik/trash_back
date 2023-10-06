package com.cats.greatCats.domain;

import com.cats.greatCats.domain.product.material.MaterialResponse;
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