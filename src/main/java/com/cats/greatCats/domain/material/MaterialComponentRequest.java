package com.cats.greatCats.domain.material;

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
public class MaterialComponentRequest implements Serializable {
    private Integer materialId;
}