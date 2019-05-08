package ru.mithril.demo.model;


import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
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
    private String docDate;

    @Nullable
    @Column(name = "code",length = 50, nullable = false)
    private String code;

    @Column(name = "country_id", nullable = false)
    private Long countryId;


    public Doc(String name, String docNumber, String docDate){
        this.name = name;
        this.docNumber = docNumber;
        this.docDate = docDate;
    }

}
