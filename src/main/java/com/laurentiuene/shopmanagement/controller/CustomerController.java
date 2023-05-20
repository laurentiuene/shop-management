package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.dto.customer.CustomerDto;
import com.laurentiuene.shopmanagement.mapper.CustomerDtoMapper;
import com.laurentiuene.shopmanagement.service.customer.CustomerService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @PostMapping
    public Integer createCustomer(@RequestBody CustomerDto customerDto) {
        return customerService.createCustomer(customerDtoMapper.mapToEntity(customerDto));
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Integer customerId) {
        customerService.deleteCustomer(customerId);
    }
}
