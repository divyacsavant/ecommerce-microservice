package com.divya.order_service.service;

import com.divya.order_service.dto.OrderRequest;
import com.divya.order_service.dto.ProductResponse;
import com.divya.order_service.entity.Order;
import com.divya.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.RequiredArgsConstructor;
import com.divya.order_service.controller.ProductClient;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate restTemplate;
    private final ProductClient productClient;

   
    public Order createOrder(
        OrderRequest request) {

        ProductResponse product =productClient
                .getProduct(request.getProductId());

        if(product.getStock()
                < request.getQuantity()) {

            throw new RuntimeException(
                    "Insufficient stock");
        }

        double total =
                product.getPrice()
                        * request.getQuantity();

        Order order =
                Order.builder()
                        .productId(
                                request.getProductId())
                        .quantity(
                                request.getQuantity())
                        .totalPrice(total)
                        .build();

        return repository.save(order);
    }

}


