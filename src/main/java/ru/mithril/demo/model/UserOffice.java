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
@Table(name = "user_office")
public class UserOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    @Column(name = "version", nullable = false)
    private Integer version;

    @Nullable
    @Column(name = "office_id", length = 50, nullable = false)
    private Long officeId;

    @Nullable
    @Column(name = "user_id", length = 50, nullable = false)
    private Long userId;


}
