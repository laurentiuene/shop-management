package com.laurentiuene.shopmanagement.service.product;

import com.laurentiuene.shopmanagement.model.Product;
import java.util.List;

public interface ProductService {

    List<Product> getAll();

    Product getOne(Integer productId);

    Integer createProduct(Product product);

    void deleteProduct(Integer productId);
}
