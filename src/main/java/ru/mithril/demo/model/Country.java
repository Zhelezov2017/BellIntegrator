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
    @Column(name = "version", nullable = false)
    private Integer version;

    @Nullable
    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Nullable
    @Column(name = "code",length = 643, nullable = false)
    private String code;


}
