package com.cats.greatCats.domain.recycling;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BinRepository extends JpaRepository<Bin, Integer> {

    @Override
    Optional<Bin> findById(Integer integer);
}