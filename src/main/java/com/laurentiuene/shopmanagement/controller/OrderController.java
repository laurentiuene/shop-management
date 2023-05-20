package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.model.Order;
import com.laurentiuene.shopmanagement.repository.OrderRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderRepository orderRepository;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

}
