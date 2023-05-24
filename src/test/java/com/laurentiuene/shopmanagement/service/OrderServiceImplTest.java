package com.laurentiuene.shopmanagement.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.laurentiuene.shopmanagement.dto.order.OrderRequestDto;
import com.laurentiuene.shopmanagement.model.Customer;
import com.laurentiuene.shopmanagement.repository.CustomerRepository;
import com.laurentiuene.shopmanagement.repository.OrderRepository;
import com.laurentiuene.shopmanagement.repository.StaffRepository;
import com.laurentiuene.shopmanagement.service.order.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

    private final Integer ID = 1;

    @InjectMocks
    OrderServiceImpl orderService;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    StaffRepository staffRepository;
    @Mock
    OrderRepository orderRepository;

    @Test
    void whenCreatingOrderWithNotExistentCustomerThenThrowException() {
        OrderRequestDto mockDto = mock(OrderRequestDto.class);
        when(mockDto.customerId()).thenReturn(ID);
        when(customerRepository.retrieveById(Mockito.anyInt())).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class,
            () -> orderService.createOrder(mockDto),
            "Customer with id " + ID + " was not found.");
    }

    @Test
    void whenCreatingOrderWithNotExistentStaffMemberThenThrowException() {
        OrderRequestDto mockDto = mock(OrderRequestDto.class);
        Customer mockCustomer = mock(Customer.class);
        when(mockDto.designatedMemberStaffId()).thenReturn(ID);
        when(customerRepository.retrieveById(Mockito.anyInt())).thenReturn(mockCustomer);
        when(staffRepository.retrieveById(Mockito.anyInt())).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class,
            () -> orderService.createOrder(mockDto),
            "Staff member with id " + ID + " was not found.");
    }
}
