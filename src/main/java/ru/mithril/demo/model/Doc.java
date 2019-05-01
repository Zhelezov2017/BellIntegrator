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
    @Column(name = "version", nullable = false)
    private Integer version;

    @Nullable
    @Column(name = "name",length = 50, nullable = false)
    private String name;

    @Column(name = "doc_number", length = 50, nullable = false)
    private String docNumber;

    @Column(name = "doc_date", nullable = false)
    private Date docDate;

    @Nullable
    @Column(name = "code",length = 50, nullable = false)
    private String code;

    @Column(name = "country_id", nullable = false)
    private Long countryId;

    //@ManyToOne
    //@JoinColumn
    //private List<User> users;

}
