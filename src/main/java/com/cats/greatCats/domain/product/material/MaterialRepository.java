package com.cats.greatCats.domain.product.material;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MaterialRepository extends JpaRepository<Material, Integer> {
    @Query("select m from Material m order by m.name")
    List<Material> findAllMaterials();




}