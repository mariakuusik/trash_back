package com.cats.greatCats.business.recycling;

import com.cats.greatCats.business.product.BinService;
import com.cats.greatCats.business.recycling.dto.BinDto;
import com.cats.greatCats.domain.recycling.Bin;
import com.cats.greatCats.domain.recycling.BinMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecyclingService {
    @Resource
    BinService binService;

    @Resource
    BinMapper binMapper;

    public List<Bin> getAllBins() {
        List<Bin> bins = binService.getAllBins();
        for (Bin bin : bins) {
            List<BinDto> binDtos = binMapper.toBinDtos(bins);
            BinDto binDto = binMapper.toBinDto(bin);
            binDtos.add(binDto);
        }
        return bins;
    }
}
