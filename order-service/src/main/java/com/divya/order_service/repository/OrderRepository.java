package com.divya.order_service.repository;

import com.divya.order_service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository
extends JpaRepository<
        Order,
        Long> {
}