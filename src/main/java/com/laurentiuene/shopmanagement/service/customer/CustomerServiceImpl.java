package com.laurentiuene.shopmanagement.service.customer;

import com.laurentiuene.shopmanagement.model.Customer;
import com.laurentiuene.shopmanagement.repository.CustomerRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

}
