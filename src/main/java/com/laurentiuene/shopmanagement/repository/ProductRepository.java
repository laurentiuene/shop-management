package com.laurentiuene.shopmanagement.repository;

import com.laurentiuene.shopmanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {

}
