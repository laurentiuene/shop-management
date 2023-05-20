package com.laurentiuene.shopmanagement.dto.order;

import java.time.LocalDate;

public record OrderRequestDto(LocalDate receivedDate,
                              Integer customerId,
                              Integer designatedMemberStaffId) {

}
