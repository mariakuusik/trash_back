package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.business.product.material.dto.MaterialComponentResponse;
import com.cats.greatCats.domain.product.ProductComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link ProductComponent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComponentResponse implements Serializable {
    private Integer componentId;
    private String componentName;
    private List <MaterialComponentResponse> materialComponentResponse;
}