package com.cats.greatCats.business.product.component;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.cats.greatCats.domain.product.component.Component}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComponentResponse implements Serializable {
    private Integer componentId;
    @NotNull
    @Size(max = 255)
    private String componentName;
}