package com.laurentiuene.shopmanagement.repository;

import com.laurentiuene.shopmanagement.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

}
