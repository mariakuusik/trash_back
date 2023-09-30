package com.cats.greatCats.business;

import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.ProductMapper;
import com.cats.greatCats.domain.product.ProductResponse;
import com.cats.greatCats.domain.product.ProductService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;


    public List<ProductResponse> getProducts(Integer companyId) {
        List<Product> products = productService.findActiveProductsBy(companyId);
        List<ProductResponse> productResponses = productMapper.toProductResponses(products);
        return productResponses;

    }
}
