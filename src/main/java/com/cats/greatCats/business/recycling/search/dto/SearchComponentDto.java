package com.cats.greatCats.business.recycling.search.dto;

import com.cats.greatCats.domain.product.component.ProductComponent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link ProductComponent}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchComponentDto implements Serializable {
    private String componentSortingInstructions;
    private String componentName;
    private String componentBinName;
    private String componentBinComments;
}