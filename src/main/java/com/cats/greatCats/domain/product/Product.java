package com.cats.greatCats.domain.product;

import com.cats.greatCats.domain.company.Company;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

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

}