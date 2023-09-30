package com.cats.greatCats.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductComponentMaterialRepository extends JpaRepository<ProductComponentMaterial, Integer> {
    @Query("select p from ProductComponentMaterial p where p.product.id = ?1")
    List<ProductComponentMaterial> findComponentsAndMaterialsBy(Integer id);


}