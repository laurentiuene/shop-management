package com.laurentiuene.shopmanagement.service.product;

import com.laurentiuene.shopmanagement.model.Product;
import com.laurentiuene.shopmanagement.repository.ProductRepository;
import jakarta.transaction.Transactional;
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

    @Override
    public Product getOne(Integer productId) {
        return productRepository.retrieveById(productId);
    }

    @Override
    @Transactional
    public Integer createProduct(Product product) {
        return productRepository.save(product).getProductId();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepository.deleteById(productId);
    }

}
