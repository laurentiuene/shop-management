package com.laurentiuene.shopmanagement.mapper;

import com.laurentiuene.shopmanagement.dto.order.OrderResponseDto;
import com.laurentiuene.shopmanagement.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CustomerDtoMapper.class, StaffDtoMapper.class})
public interface OrderDtoMapper {

    @Mapping(source = "customer", target = "customerDto")
    @Mapping(source = "designatedStaffMember", target = "designatedStaffMemberDto")
    OrderResponseDto mapToDto(Order order);
}
