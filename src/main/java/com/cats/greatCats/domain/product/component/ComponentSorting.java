package com.cats.greatCats.domain.product.component;

import com.cats.greatCats.domain.product.component.Component;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "component_sorting")
public class ComponentSorting {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "component_id", nullable = false)
    private Component component;

    @Size(max = 255)
    @NotNull
    @Column(name = "bin_name", nullable = false)
    private String binName;

    @Size(max = 500)
    @NotNull
    @Column(name = "instructions", nullable = false, length = 500)
    private String instructions;

}