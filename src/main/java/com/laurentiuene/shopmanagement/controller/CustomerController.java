package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.model.Customer;
import com.laurentiuene.shopmanagement.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/all")
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }
}
