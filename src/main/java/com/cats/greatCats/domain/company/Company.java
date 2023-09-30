package com.cats.greatCats.domain.company;

import com.cats.greatCats.domain.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 10)
    @NotNull
    @Column(name = "registrationcode", nullable = false, length = 10)
    private String registrationcode;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

}