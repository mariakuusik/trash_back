package com.cats.greatCats.business.product;

import com.cats.greatCats.domain.recycling.Sorting;
import com.cats.greatCats.domain.recycling.SortingRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SortingService {

    @Resource
    private SortingRepository sortingRepository;



    public Optional<Sorting> getSortingId(Integer sortingId) {
        return sortingRepository.findById(sortingId);
    }
}
