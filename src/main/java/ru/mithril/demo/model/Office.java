package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

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
    @Column(name = "version", nullable = false)
    private Integer version;


    @Column(name = "name",length = 50, nullable = false)
    private String name;


    @Column(name = "address",length = 50, nullable = false)
    private String address;

    @Column(name = "phone",length = 50)
    private String phone;

    @Column(name = "is_active", nullable = false)
    private String isActive;

    @Column(name = "orgId")
    private Long orgId;

    //@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    //@JoinColumn(name = "office_id")
    //private List<User> users;

}
