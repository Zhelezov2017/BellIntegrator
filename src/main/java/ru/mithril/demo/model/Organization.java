package ru.mithril.demo.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;



@Data
@AllArgsConstructor
@Builder
public class Organization {

    @Id
    private Long id;

    private String name;

    private String fullName;

    private Integer inn;

    private Integer kpp;

    private String address;

    private Long phone;

    private Boolean isActive;

    private Long version;
}
