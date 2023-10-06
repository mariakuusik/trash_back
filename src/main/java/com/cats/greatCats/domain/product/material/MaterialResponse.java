package com.cats.greatCats.domain.product.material;

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
    @NotNull
    @Size(max = 255)
    private String materialName;
    @Size(max = 500)
    private String materialDescription;
}