package com.divya.product_service.controller;

import com.divya.product_service.dto.ProductDto;
import com.divya.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.divya.product_service.dto.ProductDetailsResponse;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService
            productService;

    @PostMapping
    public ProductDto createProduct(
            @RequestBody ProductDto dto) {

        return productService
                .createProduct(dto);
    }

    @GetMapping
    public List<ProductDto>
    getAllProducts() {

        return productService
                .getAllProducts();
    }

        @GetMapping("/{id}")
        public ProductDetailsResponse
        getProductDetails(
                @PathVariable Long id) {

        return productService
                .getProductDetails(id);
        }

}