package com.divya.order_service.service;

import com.divya.order_service.dto.OrderRequest;
import com.divya.order_service.dto.ProductResponse;
import com.divya.order_service.entity.Order;
import com.divya.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class OrderService {

    private final OrderRepository repository;
    private final RestTemplate restTemplate;

    public OrderService(
            OrderRepository repository,
            RestTemplate restTemplate) {

        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Order createOrder(
        OrderRequest request) {

        ProductResponse product =
                restTemplate.getForObject(
                        "http://PRODUCT-SERVICE/products/"
                                + request.getProductId(),
                        ProductResponse.class);

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


