package com.laurentiuene.shopmanagement.dto.customer;

import java.time.LocalDate;

public record CustomerDto(String firstName,
                          String lastName,
                          LocalDate birthDate,
                          String email,
                          LocalDate registrationDate) {

}

