package com.laurentiuene.shopmanagement.repository;

import static com.laurentiuene.shopmanagement.utils.LoggerUtils.logWithRed;

import com.laurentiuene.shopmanagement.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem,Integer> {

    default OrderItem retrieveById(Integer id) {
        return this.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(logWithRed("OrderItem with id " + id + " was not found.")));
    }
}
