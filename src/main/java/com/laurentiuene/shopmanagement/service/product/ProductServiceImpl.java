package com.laurentiuene.shopmanagement.service.product;

import com.laurentiuene.shopmanagement.model.Product;
import com.laurentiuene.shopmanagement.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
