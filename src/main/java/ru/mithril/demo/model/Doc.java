package ru.mithril.demo.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@Builder
@Table(name = "doc")
public class Doc{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    @Nullable
    private String name;

    @Column(name = "doc_number", nullable = false)
    private String docNumber;

    @Column(name = "doc_date", nullable = false)
    private Date docDate;

    @Nullable
    private String code;

    @Column(name = "country_id")
    private Long countryId;

    //@ManyToOne
    //@JoinColumn
    //private List<User> users;

}
