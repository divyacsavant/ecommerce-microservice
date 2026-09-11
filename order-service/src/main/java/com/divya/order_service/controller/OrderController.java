package com.divya.order_service.controller;

import com.divya.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;
import com.divya.order_service.dto.OrderRequest;
import com.divya.order_service.entity.Order;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order createOrder(
            @RequestBody
            OrderRequest request) {

        return orderService
                .createOrder(request);
}
}

