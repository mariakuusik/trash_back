package com.cats.greatCats.domain.recycling;

import com.cats.greatCats.business.recycling.dto.BinDto;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface BinMapper {

    @Mapping(source = "id", target = "binId")
    @Mapping(source = "name", target = "binName")
    @Mapping(source = "comments", target = "binComments")
    BinDto toBinDto(Bin bin);

    List<BinDto>toBinDtos(List<Bin> bins);


}