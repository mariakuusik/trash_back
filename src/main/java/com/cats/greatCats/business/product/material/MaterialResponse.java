package com.cats.greatCats.business.product.material;

import com.cats.greatCats.domain.product.material.Material;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Material}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MaterialResponse implements Serializable {
    private Integer materialId;
    @NotNull
    @Size(max = 255)
    private String materialName;
    @Size(max = 500)
    private String materialDescription;
}