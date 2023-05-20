package com.laurentiuene.shopmanagement.repository;

import static com.laurentiuene.shopmanagement.utils.LoggerUtils.logWithRed;

import com.laurentiuene.shopmanagement.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock,Integer> {

    default Stock retrieveById(Integer id) {
        return this.findById(id)
            .orElseThrow(() -> new IllegalArgumentException(logWithRed("Stock entry with id " + id + " was not found.")));
    }
}
