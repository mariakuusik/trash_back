package com.cats.greatCats.business.product;

import com.cats.greatCats.domain.recycling.Bin;
import com.cats.greatCats.domain.recycling.BinRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BinService {

    @Resource
    private BinRepository binRepository;


    public Optional<Bin> getBinId(Integer binId) {
        return binRepository.findById(binId);
    }

    public List<Bin> getAllBins() {
        return binRepository.findAll();
    }
}
