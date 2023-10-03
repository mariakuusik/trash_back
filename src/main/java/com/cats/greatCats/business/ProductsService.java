package com.cats.greatCats.business;

import com.cats.greatCats.domain.product.*;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductsService {

    @Resource
    private ProductService productService;

    @Resource
    private ProductMapper productMapper;


    public List<ActiveProductResponse> getActiveProducts(Integer companyId) {
        List<Product> products = productService.findActiveProductsBy(companyId);
        List<ActiveProductResponse> activeProductRespons = productMapper.toActiveProductResponses(products);
        return activeProductRespons;
    }

    public List<ProductResponse> getProducts(Integer companyId) {
        List<Product> products = productService.findProductsBy(companyId);
        List<ProductResponse> productResponse = productMapper.toProductResponse(products);
        return productResponse ;
    }

    public void updateProductStatus(ProductStatusRequest productStatusRequest) {
        Product product = productService.findProductBy(productStatusRequest.getProductId());
        product.setIsActive(productStatusRequest.getProductIsActive());
        productService.saveProduct(product);
    }
}
