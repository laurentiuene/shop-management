package com.laurentiuene.shopmanagement.mapper;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

import com.laurentiuene.shopmanagement.dto.customer.CustomerDto;
import com.laurentiuene.shopmanagement.model.Customer;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CustomerDtoMapperTest {

    private static final String EMAIL = "EMAIL";
    private static final String LAST_NAME = "LAST_NAME";
    private static final String FIRST_NAME = "FIRST_NAME";
    private static final LocalDate BIRTH_DATE = LocalDate.now();
    private static final LocalDate REGISTRATION_DATE = LocalDate.now();

    @InjectMocks
    CustomerDtoMapperImpl customerDtoMapper;

    @Test
    void whenMappingFromEntityToDtoThenReturnCorrectResult() {
        Customer mockCustomer = mock(Customer.class);
        when(mockCustomer.getEmail()).thenReturn(EMAIL);
        when(mockCustomer.getLastName()).thenReturn(LAST_NAME);
        when(mockCustomer.getFirstName()).thenReturn(FIRST_NAME);
        when(mockCustomer.getBirthDate()).thenReturn(BIRTH_DATE);
        when(mockCustomer.getRegistrationDate()).thenReturn(REGISTRATION_DATE);

        CustomerDto result = customerDtoMapper.mapToDto(mockCustomer);

        assertThat(result.email()).isEqualTo(EMAIL);
        assertThat(result.lastName()).isEqualTo(LAST_NAME);
        assertThat(result.firstName()).isEqualTo(FIRST_NAME);
        assertThat(result.birthDate()).isEqualTo(BIRTH_DATE);
        assertThat(result.registrationDate()).isEqualTo(REGISTRATION_DATE);
    }

    @Test
    void whenMappingFromDtoToEntityThenReturnCorrectResult() {
        CustomerDto mockDto = mock(CustomerDto.class);
        when(mockDto.birthDate()).thenReturn(BIRTH_DATE);
        when(mockDto.firstName()).thenReturn(FIRST_NAME);
        when(mockDto.lastName()).thenReturn(LAST_NAME);
        when(mockDto.registrationDate()).thenReturn(REGISTRATION_DATE);
        when(mockDto.email()).thenReturn(EMAIL);

        Customer result = customerDtoMapper.mapToEntity(mockDto);

        assertThat(result.getEmail()).isEqualTo(EMAIL);
        assertThat(result.getLastName()).isEqualTo(LAST_NAME);
        assertThat(result.getFirstName()).isEqualTo(FIRST_NAME);
        assertThat(result.getBirthDate()).isEqualTo(BIRTH_DATE);
        assertThat(result.getRegistrationDate()).isEqualTo(REGISTRATION_DATE);
    }

}
