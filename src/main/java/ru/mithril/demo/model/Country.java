package ru.mithril.demo.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Country {

    private String name;

    private Long code;

    private Long ownerId;

    private Long version;

}
