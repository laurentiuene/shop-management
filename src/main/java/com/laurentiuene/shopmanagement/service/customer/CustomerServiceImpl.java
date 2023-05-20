package com.laurentiuene.shopmanagement.service.customer;

import static com.laurentiuene.shopmanagement.utils.LoggerUtils.logWithGreen;

import com.laurentiuene.shopmanagement.model.Customer;
import com.laurentiuene.shopmanagement.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public Integer createCustomer(Customer customer) {
        return customerRepository.save(customer).getCustomerId();
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerRepository.deleteById(customerId);
        log.info(logWithGreen("Customer with id " + customerId + " was deleted."));
    }

}
