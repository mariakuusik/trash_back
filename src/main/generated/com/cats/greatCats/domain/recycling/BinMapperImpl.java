package com.cats.greatCats.domain.recycling;

import com.cats.greatCats.business.recycling.dto.BinDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-10-29T12:06:20+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class BinMapperImpl implements BinMapper {

    @Override
    public BinDto toBinDto(Bin bin) {
        if ( bin == null ) {
            return null;
        }

        BinDto binDto = new BinDto();

        binDto.setBinId( bin.getId() );
        binDto.setBinName( bin.getName() );
        binDto.setBinComments( bin.getComments() );

        return binDto;
    }

    @Override
    public List<BinDto> toBinDtos(List<Bin> bins) {
        if ( bins == null ) {
            return null;
        }

        List<BinDto> list = new ArrayList<BinDto>( bins.size() );
        for ( Bin bin : bins ) {
            list.add( toBinDto( bin ) );
        }

        return list;
    }
}
