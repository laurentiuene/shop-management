package com.laurentiuene.shopmanagement.repository;

import static com.laurentiuene.shopmanagement.utils.LoggerUtils.logWithRed;

import com.laurentiuene.shopmanagement.model.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Integer> {

    default Staff retrieveById(Integer id) {
        return this.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(logWithRed("Staff member with id " + id + " was not found.")));
    }
}
