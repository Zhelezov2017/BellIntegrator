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
@Table(name = "doc")
public class Doc{

    @Version
    private Integer version;

    @Nullable
    private String name;

    @Nullable
    private String code;

    @Column(name = "owner_id")
    private Long ownerId;

    @ManyToMany
    @JoinColumn
    private List<User> users;

}
