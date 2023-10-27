package com.cats.greatCats.domain.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Integer> {

    //CompanyId järgi aktiivsed tooted:
    @Query("select p from Product p where p.company.id = ?1 and p.company.isActive = ?2 order by p.name")
    List<Product> findActiveProductsBy(Integer id, Boolean isActive);

    //CompanyId järgi kõik tooted:
    @Query("select p from Product p where p.company.id = ?1 order by p.isActive, p.name")
    List<Product> findAllProductsBy(Integer id);

    Product findProductById (Integer id);

    @Query("select p from Product p where p.upc = ?1 and p.isActive = ?2")
    Product findActiveProductBy(String upc, Boolean isActive);

}



