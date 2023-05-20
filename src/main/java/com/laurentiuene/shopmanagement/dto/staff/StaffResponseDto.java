package com.laurentiuene.shopmanagement.dto.staff;

import com.laurentiuene.shopmanagement.model.enums.StaffPositionEnum;
import java.time.LocalDate;

public record StaffResponseDto(String firstName,
                       String lastName,
                       StaffPositionEnum position,
                       String phone,
                       String email,
                       String username,
                       String password,
                       LocalDate hireDate) {

}

