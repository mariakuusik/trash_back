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

    public List<Product> findProductsBy(Integer companyId) {
        return productRepository.findAllProductsBy(companyId);
    }


    public Product findProductBy(Integer id) {
        return productRepository.findProductById(id);
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }
}
