package com.cats.greatCats.domain.product.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductComponentRepository extends JpaRepository<ProductComponent, Integer> {
    @Query("select p from ProductComponent p where p.product.id = ?1 order by p.component.name")
    List<ProductComponent> findComponentsBy(Integer id);




}