package com.laurentiuene.shopmanagement.repository;

import static com.laurentiuene.shopmanagement.utils.LoggerUtils.logWithRed;

import com.laurentiuene.shopmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    default Customer retrieveById(Integer id) {
        return this.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(logWithRed("Customer with id " + id + " was not found.")));
    }
}
