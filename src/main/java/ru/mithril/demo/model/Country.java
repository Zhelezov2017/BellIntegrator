package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Version;


@Data
@AllArgsConstructor
@Builder
@Table(name = "country")
public class Country {


    @Version
    private Integer version;

    @Nullable
    private String name;

    @Nullable
    private String code;

    @Column(name = "owner_id")
    private Long ownerId;

}
