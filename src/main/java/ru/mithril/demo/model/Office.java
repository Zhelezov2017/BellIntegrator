package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "office")
public class Office {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Nullable
    private String name;

    @Nullable
    private String address;


    private String phone;

    @Column(name = "is_active")
    private String isActive;


    private Long orgId;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "office_id")
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Office office;
}
