package com.cats.greatCats.domain.product.image;

import com.cats.greatCats.domain.product.image.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Integer> {
}