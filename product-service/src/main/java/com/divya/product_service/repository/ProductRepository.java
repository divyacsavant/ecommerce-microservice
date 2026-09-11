package com.divya.product_service.repository;

import com.divya.product_service.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
        extends JpaRepository<
                Product,
                Long> {
}