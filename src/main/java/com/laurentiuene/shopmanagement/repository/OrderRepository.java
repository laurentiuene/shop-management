package com.laurentiuene.shopmanagement.repository;

import com.laurentiuene.shopmanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

}
