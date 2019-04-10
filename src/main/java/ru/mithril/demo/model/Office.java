package ru.mithril.demo.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;



@Data
@AllArgsConstructor
@Builder
public class Office {

    @Id
    private Long id;

    private String name;

    private String address;

    private Long phone;

    private Boolean isActive;

    private Long ownerId;

    private Long version;
}
