package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.dto.product.ProductDto;
import com.laurentiuene.shopmanagement.mapper.ProductDtoMapper;
import com.laurentiuene.shopmanagement.service.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    @GetMapping("/all")
    public List<ProductDto> getAll() {
        return productService.getAll().stream()
            .map(productDtoMapper::mapToDto)
            .toList();
    }

}
