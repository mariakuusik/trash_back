package com.cats.greatCats.business.recycling.search;

import com.cats.greatCats.Sorting;
import com.cats.greatCats.business.product.component.ProductComponentService;
import com.cats.greatCats.business.recycling.search.dto.SearchComponentDto;
import com.cats.greatCats.business.recycling.search.dto.SearchDto;
import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.ProductService;
import com.cats.greatCats.domain.product.component.ProductComponent;
import com.cats.greatCats.domain.product.component.ProductComponentMapper;
import com.cats.greatCats.domain.search.Bin;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

            Optional<ProductComponent> productComponentOptional = productComponentService.findProductBy(productId);
            if(productComponentOptional.isPresent()){
                ProductComponent productComponent = productComponentOptional.get();
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

//    private void findProductComponentsAndComponentRecycling(Product activeProduct, SearchDto searchDto) {
//        List<ProductComponent> components = productComponentService.findComponentsBy(activeProduct.getId());
//        if (components != null) {
//
//            List<SearchComponentDto> searchComponentDtos = productComponentMapper.toSearchComponentDtos(components);
//            searchDto.setSearchComponentDtos(searchComponentDtos);
//
////            List<SearchComponentDto> searchComponentDtos = new ArrayList<>();
////            for (ProductComponent component : components) {
////                SearchComponentDto searchComponentDto = new SearchComponentDto();
////                searchComponentDto.setComponentName(component.getComponent().getName());
////                validateComponentHasBin(component, searchComponentDto);
////                validateComponentHasSorting(component, searchComponentDto);
////                searchComponentDtos.add(searchComponentDto);
//            }
//
//        }
//    }

    private static void validateProductHasSorting(Product activeProduct, SearchDto searchDto) {
        Sorting productSorting = activeProduct.getSorting();
        if (productSorting != null) {
            searchDto.setProductSortingInstructions(productSorting.getInstructions());
        }
    }

    private static void validateProductHasBin(Product activeProduct, SearchDto searchDto) {
        Bin productBin = activeProduct.getBin();
        if (productBin != null) {
            searchDto.setProductBinName(productBin.getName());
            searchDto.setProductBinComments(productBin.getComments());
        }
    }

    private static void validateComponentHasSorting(ProductComponent component, SearchComponentDto searchComponentDto) {
        Sorting componentSorting = component.getComponent().getSorting();
        if (componentSorting != null) {
            searchComponentDto.setComponentSortingInstructions(componentSorting.getInstructions());
        }
    }

    private static void validateComponentHasBin(ProductComponent component, SearchComponentDto searchComponentDto) {
        Bin componentBin = component.getComponent().getBin();
        if (componentBin != null) {
            searchComponentDto.setComponentBinName(componentBin.getName());
            searchComponentDto.setComponentBinComments(componentBin.getComments());
        }
    }

}
