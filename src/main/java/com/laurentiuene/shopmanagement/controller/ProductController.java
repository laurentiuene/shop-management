package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.model.Product;
import com.laurentiuene.shopmanagement.repository.ProductRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
