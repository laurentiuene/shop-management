package com.laurentiuene.shopmanagement.service.order;

import com.laurentiuene.shopmanagement.dto.order.OrderRequestDto;
import com.laurentiuene.shopmanagement.model.Order;
import com.laurentiuene.shopmanagement.model.enums.OrderStatusEnum;
import com.laurentiuene.shopmanagement.repository.CustomerRepository;
import com.laurentiuene.shopmanagement.repository.OrderRepository;
import com.laurentiuene.shopmanagement.repository.StaffRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final StaffRepository staffRepository;

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    @Transactional
    public Integer createOrder(OrderRequestDto dto) {
        return orderRepository.save(
            Order.builder()
            .receivedDate(dto.receivedDate())
            .customer(customerRepository.retrieveById(dto.customerId()))
            .designatedStaffMember(staffRepository.retrieveById(dto.designatedMemberStaffId()))
            .status(OrderStatusEnum.PENDING)
            .build()
        ).getOrderId();
    }

    @Override
    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

}
