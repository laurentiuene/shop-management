package com.laurentiuene.shopmanagement.dto.staff;

import com.laurentiuene.shopmanagement.model.enums.StaffPositionEnum;

public record StaffRequestDto(String firstName,
                              String lastName,
                              StaffPositionEnum position,
                              String phone,
                              String email,
                              String username,
                              String password) {

}
