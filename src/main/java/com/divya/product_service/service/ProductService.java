package com.divya.product_service.service;

import com.divya.product_service.dto.ProductDto;
import com.divya.product_service.entity.Product;
import com.divya.product_service.mapper.ProductMapper;
import com.divya.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository
            productRepository;

    public ProductDto createProduct(
            ProductDto dto) {

        Product product =
                ProductMapper.toEntity(dto);

        Product saved =
                productRepository
                        .save(product);

        return ProductMapper
                .toDto(saved);
    }

    public List<ProductDto> getAllProducts() {

        return productRepository
                .findAll()
                .stream()
                .map(ProductMapper::toDto)
                .toList();
    }
}