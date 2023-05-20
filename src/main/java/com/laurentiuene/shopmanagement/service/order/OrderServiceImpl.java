package com.laurentiuene.shopmanagement.service.order;

import com.laurentiuene.shopmanagement.model.Order;
import com.laurentiuene.shopmanagement.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

}
