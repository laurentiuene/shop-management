package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.dto.customer.CustomerDto;
import com.laurentiuene.shopmanagement.mapper.CustomerDtoMapper;
import com.laurentiuene.shopmanagement.service.customer.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerDtoMapper customerDtoMapper;

    @GetMapping("/all")
    public List<CustomerDto> getAll() {
        return customerService.getAll().stream()
            .map(customerDtoMapper::mapToDto)
            .toList();
    }
}
