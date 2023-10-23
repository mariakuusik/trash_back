package com.cats.greatCats.business.search.dto;

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
public class SearchResultsByUpc implements Serializable {
    private String productName;
    private String productBinName;
    private String productBinComments;
    private Integer componentId;
    private String componentName;
    private String componentBinName;
    private String componentBinComments;
    //TODO: Lisada SORTING ja MATERIAL. Sorting vist oleks pidanud lisama juba product-component kaudu,
    //TODO: sest see mõlema tabeliga seotud. Äkki muuta see nii, et saaks ainult productile lisada,
    //TODO: kas kasutaja lisab ise selle, tekstina, või on andmebaasis olemas?
}