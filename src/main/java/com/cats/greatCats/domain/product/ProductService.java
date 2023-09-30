package com.cats.greatCats.domain.product;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {


    @Resource
    private ProductRepository productRepository;

    public List<Product> findActiveProductsBy(Integer companyId) {
        return productRepository.findActiveProductsBy(companyId, Boolean.TRUE);
    }
}
