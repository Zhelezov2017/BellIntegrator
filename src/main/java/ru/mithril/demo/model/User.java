package ru.mithril.demo.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String secondName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Nullable
    private String position;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "citizen_ship_name")
    private String citizenShipName;

    @Column(name = "citizen_ship_code")
    private String citizenShipCode;

    @Column(name = "is_identified")
    private String isIdentified;

    @Column(name = "doc_id")
    private Long docId;


    public User(String firstName, String middleName){
        this.firstName = firstName;
        this.middleName = middleName;
    }


//    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
//    @JoinColumn(name = "owner_id")
//    private List<Country> countries;
//
//    @ManyToOne
//    @JoinColumn
//    private Office office;





}
