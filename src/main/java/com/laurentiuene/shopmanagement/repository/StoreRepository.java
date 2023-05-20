package com.laurentiuene.shopmanagement.repository;

import static com.laurentiuene.shopmanagement.utils.LoggerUtils.logWithRed;

import com.laurentiuene.shopmanagement.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

    default Store retrieveById(Integer id) {
        return this.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(logWithRed("Store with id " + id + " was not found.")));
    }
}
