package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Nullable
    private String name;

    @Nullable
    private String code;


}
