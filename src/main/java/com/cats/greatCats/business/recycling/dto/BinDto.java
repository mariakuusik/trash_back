package com.cats.greatCats.business.recycling.dto;

import com.cats.greatCats.domain.recycling.Bin;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link Bin}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BinDto implements Serializable {
    private Integer binId;
    @Size(max = 255)
    private String binName;
    @Size(max = 500)
    private String binComments;
}