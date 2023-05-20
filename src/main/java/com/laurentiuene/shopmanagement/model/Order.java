package com.laurentiuene.shopmanagement.model;

import com.laurentiuene.shopmanagement.model.enums.OrderStatusEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order")
    private Integer orderId;

    @Column(name = "received_date")
    private LocalDate receivedDate;

    @Enumerated(value = EnumType.STRING)
    private OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_staff")
    private Staff designatedStaffMember;
}
