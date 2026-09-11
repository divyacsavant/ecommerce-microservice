package com.divya.product_service.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailsResponse {

    private Long id;

    private String name;

    private Double price;

    private Integer stock;
}