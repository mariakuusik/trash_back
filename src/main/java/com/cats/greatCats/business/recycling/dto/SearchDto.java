package com.cats.greatCats.business.recycling.dto;

import com.cats.greatCats.domain.product.ProductComponent;
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
public class SearchDto implements Serializable {
    private Integer productId;
    private String productSortingInstructions;
    private String productName;
    private String productBinName;
    private String productBinComments;
    private List <SearchComponentDto> searchComponentDtos;

}