package com.laurentiuene.shopmanagement.mapper;

import com.laurentiuene.shopmanagement.dto.customer.CustomerDto;
import com.laurentiuene.shopmanagement.model.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerDtoMapper {

    CustomerDto mapToDto(Customer customer);

    Customer mapToEntity(CustomerDto customerDto);
}
