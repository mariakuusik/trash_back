package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.Bin;
import com.cats.greatCats.MaterialComponent;
import com.cats.greatCats.Sorting;
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
@Table(name = "component")
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "material_id", nullable = false)
    private Integer materialId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sorting_id")
    private Sorting sorting;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bin_id")
    private Bin bin;

    @OneToMany(mappedBy = "component")
    private Set<MaterialComponent> materialComponents = new LinkedHashSet<>();

    @OneToMany(mappedBy = "component")
    private Set<ProductComponent> productComponents = new LinkedHashSet<>();

}