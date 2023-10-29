package com.cats.greatCats.domain.recycling;

import com.cats.greatCats.domain.recycling.Sorting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SortingRepository extends JpaRepository<Sorting, Integer> {
}