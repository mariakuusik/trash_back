package com.cats.greatCats.domain.material;

import com.cats.greatCats.domain.product.component.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MaterialComponentRepository extends JpaRepository<MaterialComponent, Integer> {
    @Transactional
    @Modifying
    @Query("delete from MaterialComponent m where m.component = ?1")
    int deleteByComponent(Component component);

    @Query("select m from MaterialComponent m where m.component.id = ?1")
    List<MaterialComponent> findComponentMaterialsBy(Integer componentId);







}