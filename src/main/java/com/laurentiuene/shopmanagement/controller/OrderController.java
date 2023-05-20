package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.dto.order.OrderResponseDto;
import com.laurentiuene.shopmanagement.mapper.OrderDtoMapper;
import com.laurentiuene.shopmanagement.service.order.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderDtoMapper orderDtoMapper;

    @GetMapping("/all")
    public List<OrderResponseDto> getAll() {
        return orderService.getAll().stream()
            .map(orderDtoMapper::mapToDto)
            .toList();
    }

}
