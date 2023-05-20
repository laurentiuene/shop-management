package com.laurentiuene.shopmanagement.service.customer;

import com.laurentiuene.shopmanagement.model.Customer;
import java.util.List;

public interface CustomerService {

    List<Customer> getAll();

    Integer createCustomer(Customer customer);

    void deleteCustomer(Integer customerId);
}
