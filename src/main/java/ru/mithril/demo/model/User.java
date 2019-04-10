package ru.mithril.demo.dao.entity;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class User {

    @Id
    private Long id;

    private String firstName;

    private String secondName;

    private String middleName;

    private String position;

    private Long phone;

    private String docName;

    private Long docNumber;

    private Date docDate;

    private String citizenShipName;

    private Long citizenShipCode;

    private Boolean isIdentified;

    private Long ownerId;

    private Long version;


}
