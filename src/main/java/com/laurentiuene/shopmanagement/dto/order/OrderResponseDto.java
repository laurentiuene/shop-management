package com.laurentiuene.shopmanagement.dto.order;

import com.laurentiuene.shopmanagement.dto.customer.CustomerDto;
import com.laurentiuene.shopmanagement.dto.staff.StaffResponseDto;
import com.laurentiuene.shopmanagement.model.enums.OrderStatusEnum;
import java.time.LocalDate;

public record OrderResponseDto(LocalDate receivedDate,
                               OrderStatusEnum status,
                               CustomerDto customerDto,
                               StaffResponseDto designatedStaffMemberDto) {

}
