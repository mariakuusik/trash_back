package com.cats.greatCats.business.product;

import com.cats.greatCats.domain.search.Bin;
import com.cats.greatCats.domain.search.BinRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BinService {

    @Resource
    private BinRepository binRepository;


    public Optional<Bin> getBinId(Integer binId) {
        return binRepository.findById(binId);
    }
}
