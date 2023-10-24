package com.cats.greatCats.business.product.dto;

import com.cats.greatCats.domain.material.MaterialComponentRequest;
import com.cats.greatCats.domain.product.component.ProductComponent;
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
public class ProductComponentDto implements Serializable {
    private Integer productId;
    private Integer componentId;
    private List <MaterialComponentRequest> materials;

}