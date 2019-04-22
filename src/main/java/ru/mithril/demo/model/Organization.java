package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@Builder
@Table(name = "organization")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Nullable
    private String name;

    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Nullable
    private String inn;

    @Nullable
    private String kpp;

    @Nullable
    private String address;

    private String phone;

    @Column(name = "is_active")
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "orgId")
    private List<Office> offices;
}
