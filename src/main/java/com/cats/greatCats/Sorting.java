package com.cats.greatCats;

import com.cats.greatCats.domain.product.Product;
import com.cats.greatCats.domain.product.component.Component;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "sorting")
public class Sorting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 500)
    @Column(name = "instructions", length = 500)
    private String instructions;

    @OneToMany(mappedBy = "sorting")
    private Set<Component> components = new LinkedHashSet<>();

    @OneToMany(mappedBy = "sorting")
    private Set<Product> products = new LinkedHashSet<>();

}