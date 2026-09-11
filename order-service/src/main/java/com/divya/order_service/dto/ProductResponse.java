package com.divya.order_service.dto;

import lombok.*;

@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;

    private Double price;

    private Integer stock;
}