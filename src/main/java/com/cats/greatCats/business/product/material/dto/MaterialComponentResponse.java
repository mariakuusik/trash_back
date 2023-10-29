package com.cats.greatCats.business.product.material.dto;

import com.cats.greatCats.domain.product.material.MaterialComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link MaterialComponent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialComponentResponse implements Serializable {
    private String materialName;
    private String materialDescription;
    private Integer productId;

}