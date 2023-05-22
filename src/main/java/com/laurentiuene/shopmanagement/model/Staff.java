package com.laurentiuene.shopmanagement.model;

import com.laurentiuene.shopmanagement.model.enums.RolesEnum;
import com.laurentiuene.shopmanagement.model.enums.StaffPositionEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_staff")
    private Integer staffId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Enumerated(value = EnumType.STRING)
    private StaffPositionEnum position;

    private String phone;

    private String email;

    private String username;

    private String password;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @Enumerated(value = EnumType.STRING)
    private RolesEnum role;

}
