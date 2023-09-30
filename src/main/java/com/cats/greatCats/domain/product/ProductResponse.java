package com.cats.greatCats.domain.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Product}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse implements Serializable {
    private Integer productId;
    @NotNull
    @Size(max = 255)
    private String productName;
    @NotNull
    @Size(max = 14)
    private String productUpc;
    private List <ProductComponentMaterialDto> componentsAndMaterials;
}