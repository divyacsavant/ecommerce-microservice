package com.divya.product_service.mapper;

import com.divya.product_service.dto.ProductDto;
import com.divya.product_service.entity.Product;

public class ProductMapper {

    public static ProductDto toDto(
            Product product) {

        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();
    }

    public static Product toEntity(
            ProductDto dto) {

        return Product.builder()
                .id(dto.getId())
                .name(dto.getName())
                .price(dto.getPrice())
                .stock(dto.getStock())
                .build();
    }
}