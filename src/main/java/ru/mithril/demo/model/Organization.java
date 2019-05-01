package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
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

    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "full_name",length = 50, nullable = false)
    private String fullName;


    @Column(name = "inn",length = 50, nullable = false)
    private String inn;

    @Column(name = "kpp",length = 50, nullable = false)
    private String kpp;

    @Column(name = "address",length = 50, nullable = false)
    private String address;

    @Column(name = "phone",length = 50)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "orgId")
    private List<Office> offices;
}
