package com.laurentiuene.shopmanagement.repository;

import com.laurentiuene.shopmanagement.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

}
