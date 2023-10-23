package com.cats.greatCats.domain.product;

import com.cats.greatCats.domain.search.Bin;
import com.cats.greatCats.domain.company.Company;
import com.cats.greatCats.domain.search.Sorting;
import com.cats.greatCats.domain.product.component.ProductComponent;
import com.cats.greatCats.domain.product.image.Image;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorting_id")
    private Sorting sorting;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 14)
    @NotNull
    @Column(name = "upc", nullable = false, length = 14)
    private String upc;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @OneToMany(mappedBy = "product")
    private Set<ProductComponent> productComponents = new LinkedHashSet<>();

}