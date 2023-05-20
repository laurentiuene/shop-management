package com.laurentiuene.shopmanagement.service.order;

import com.laurentiuene.shopmanagement.dto.order.OrderRequestDto;
import com.laurentiuene.shopmanagement.model.Order;
import java.util.List;

public interface OrderService {

    List<Order> getAll();

    Integer createOrder(OrderRequestDto order);

    void deleteOrder(Integer orderId);
}
