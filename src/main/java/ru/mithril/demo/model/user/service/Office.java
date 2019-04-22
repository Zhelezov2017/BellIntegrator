package ru.mithril.demo.model.user.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Office {




    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String address;
    public String phone;
    public String is_active;
    public String org_id;
    @NotNull
    public Long version;

    public Long getId() {
        return id;
    }

    public Office(Long id, String name, String address){
        this.id = id;
        this.name = name;
        this.address = address;
    }

}
