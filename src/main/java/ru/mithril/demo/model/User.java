package ru.mithril.demo.model;


import lombok.*;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "user")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Version
    private Integer version;

    @Column(name = "first_name",length = 50)
    private String firstName;

    @Column(name = "second_name",length = 50)
    private String secondName;

    @Column(name = "middle_name",length = 50)
    private String middleName;

    @Column(name = "position",length = 50)
    private String position;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "citizen_ship_name", length = 50)
    private String citizenShipName;

    @Column(name = "citizen_ship_code", length = 50)
    private String citizenShipCode;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    @Column(name = "doc_id")
    private Long docId;

    @Column(name = "office_id")
    private Long officeId;

    public User(Long id, String firstName, String secondName, String middleName, String position) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.position = position;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    Doc doc;



}
