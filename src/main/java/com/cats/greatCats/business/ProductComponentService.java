package com.cats.greatCats.business;

import com.cats.greatCats.domain.ProductComponent;
import com.cats.greatCats.domain.ProductComponentRepository;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductComponentService {

    @Resource
    private ProductComponentRepository productComponentRepository;


    public List<ProductComponent> findComponentsBy(Integer productId) {
        return productComponentRepository.findComponentsBy(productId);
    }
}
