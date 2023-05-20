package com.laurentiuene.shopmanagement.repository;

import com.laurentiuene.shopmanagement.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

}
