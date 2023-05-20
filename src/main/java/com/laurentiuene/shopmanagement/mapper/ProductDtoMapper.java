package com.laurentiuene.shopmanagement.mapper;

import com.laurentiuene.shopmanagement.dto.product.ProductDto;
import com.laurentiuene.shopmanagement.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductDtoMapper {

    ProductDto mapToDto(Product product);

    Product mapToEntity(ProductDto productDto);
}
