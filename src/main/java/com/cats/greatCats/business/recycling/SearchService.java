package com.cats.greatCats.business.recycling;

import com.cats.greatCats.business.recycling.dto.SearchComponentDto;
import com.cats.greatCats.domain.product.ProductComponentService;
import com.cats.greatCats.business.recycling.dto.SearchDto;
import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.ProductService;
import com.cats.greatCats.domain.product.ProductComponent;
import com.cats.greatCats.domain.product.ProductComponentMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchService {

    @Resource
    ProductService productService;

    @Resource
    ProductComponentService productComponentService;

    @Resource
    ProductComponentMapper productComponentMapper;

    public SearchDto searchProductAndRecyclingInfo(String productUpc) {
        SearchDto searchDto = new SearchDto();
        Product activeProduct = productService.findActiveProductByUpc(productUpc);
        if (activeProduct != null) {
            Integer productId = activeProduct.getId();

            List<ProductComponent> productComponents = productComponentService.findProductBy(productId);
            for(ProductComponent productComponent : productComponents){
                searchDto = productComponentMapper.toSearchDto(productComponent);
                findProductComponentsAndComponentRecycling(activeProduct, searchDto);
            }
        }
        return searchDto;
    }

    private void findProductComponentsAndComponentRecycling(Product activeProduct, SearchDto searchDto) {
        List<ProductComponent> components = productComponentService.findComponentsBy(activeProduct.getId());
        if (components != null) {
            List<SearchComponentDto> searchComponentDtos = productComponentMapper.toSearchComponentDtos(components);
            searchDto.setSearchComponentDtos(searchComponentDtos);
        }
    }

}
