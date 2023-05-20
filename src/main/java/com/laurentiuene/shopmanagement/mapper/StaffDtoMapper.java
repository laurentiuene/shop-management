package com.laurentiuene.shopmanagement.mapper;

import com.laurentiuene.shopmanagement.dto.staff.StaffRequestDto;
import com.laurentiuene.shopmanagement.dto.staff.StaffResponseDto;
import com.laurentiuene.shopmanagement.model.Staff;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StaffDtoMapper {

    StaffResponseDto mapToDto(Staff staff);

    Staff mapToEntity(StaffRequestDto staffDto);
}
