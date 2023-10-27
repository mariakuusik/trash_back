package com.cats.greatCats.business.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.cats.greatCats.domain.material.MaterialComponent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialComponentResponse implements Serializable {
    private String materialName;
    private String materialDescription;
    private Integer productId;

}