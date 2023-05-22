package com.laurentiuene.shopmanagement.controller;

import com.laurentiuene.shopmanagement.dto.product.ProductDto;
import com.laurentiuene.shopmanagement.mapper.ProductDtoMapper;
import com.laurentiuene.shopmanagement.service.product.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    private final ProductDtoMapper productDtoMapper;

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<ProductDto> getAll() {
        return productService.getAll().stream()
            .map(productDtoMapper::mapToDto)
            .toList();
    }

    @GetMapping("/{id}")
    public ProductDto getOne(@PathVariable("id") Integer productId) {
        return productDtoMapper.mapToDto(productService.getOne(productId));
    }

    @PostMapping
    public Integer createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDtoMapper.mapToEntity(productDto));
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Integer productId) {
        productService.deleteProduct(productId);
    }

}
