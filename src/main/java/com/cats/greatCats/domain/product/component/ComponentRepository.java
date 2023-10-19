package com.cats.greatCats.domain.product.component;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ComponentRepository extends JpaRepository<Component, Integer> {
    @Query("select c from Component c where c.id = ?1")
    List<Component> findByComponentId(Integer id);

    //See ei tööta, sest andmebaasi muudetud.
//    @Query("select c from Component c where c.material.id = ?1 order by c.name")
//    List<Component> findByMaterial(Integer id);

    @Query("select c from Component c inner join c.sorting.products products where products.id = ?1 order by c.name")
    List<Component> findByProductId(Integer id);





}