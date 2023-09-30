package com.cats.greatCats.domain.user;

import com.cats.greatCats.domain.user.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Size(max = 30)
    @NotNull
    @Column(name = "username", nullable = false, length = 30)
    private String username;

    @Size(max = 30)
    @NotNull
    @Column(name = "password", nullable = false, length = 30)
    private String password;

    @NotNull
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

}