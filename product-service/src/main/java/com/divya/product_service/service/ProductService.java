package com.divya.product_service.service;

import com.divya.product_service.dto.ProductDto;
import com.divya.product_service.entity.Product;
import com.divya.product_service.mapper.ProductMapper;
import com.divya.product_service.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.web.client.RestTemplate;
import com.divya.product_service.dto.InventoryResponse;
import com.divya.product_service.dto.ProductDetailsResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import com.divya.product_service.controller.InventoryClient;


@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository
            productRepository;
        private final RestTemplate restTemplate;
        private final InventoryClient inventoryClient;

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


        @CircuitBreaker(
        name = "inventoryService",
        fallbackMethod = "inventoryFallback")
        public ProductDetailsResponse
                getProductDetails(Long id) {

                Product product =
                        productRepository
                                .findById(id)
                                .orElseThrow();

                InventoryResponse inventory =inventoryClient
                                                .getInventory(id);

                return ProductDetailsResponse
                        .builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .stock(inventory.getQuantity())
                        .build();
        }

        public ProductDetailsResponse
                inventoryFallback(
                        Long id,
                        Exception ex) {

                Product product =
                        productRepository
                                .findById(id)
                                .orElseThrow();

                return ProductDetailsResponse
                        .builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .stock(0)
                        .build();
                }


}