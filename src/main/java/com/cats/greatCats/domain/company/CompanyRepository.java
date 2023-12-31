package com.cats.greatCats.domain.company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
    @Query("select c from Company c where c.id = ?1 and c.isActive = ?2")
    Company findActiveCompanyBy(Integer id, Boolean isActive);



}