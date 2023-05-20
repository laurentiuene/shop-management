package com.laurentiuene.shopmanagement.repository;

import com.laurentiuene.shopmanagement.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
