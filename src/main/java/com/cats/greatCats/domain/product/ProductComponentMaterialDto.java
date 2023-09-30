package com.cats.greatCats.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ProductComponentMaterial}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductComponentMaterialDto implements Serializable {
    private Integer productMaterialId;
    private String productMaterialName;
    private String productMaterialDescription;
    private Integer productComponentId;
    private String productComponentName;
}