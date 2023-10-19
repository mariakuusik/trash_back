package com.cats.greatCats.business.search;

import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.business.product.component.ProductComponentService;
import com.cats.greatCats.domain.product.ProductMapper;
import com.cats.greatCats.domain.product.ProductService;
import com.cats.greatCats.domain.product.component.ComponentService;
import com.cats.greatCats.domain.product.component.ProductComponentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

    @Resource
    ProductService productService;

    @Resource
    ProductMapper productMapper;

    @Resource
    ComponentService componentService;

    @Resource
    ProductComponentMapper productComponentMapper;

    @Resource
    ProductComponentService productComponentService;


    public void searchProductAndRecyclingInfo(String productUpc) {
        Product product = productService.findProductByUpc(productUpc);

    }
}
