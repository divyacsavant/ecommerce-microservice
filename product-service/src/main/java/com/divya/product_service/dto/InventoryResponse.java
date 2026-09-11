package com.divya.product_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    private Long productId;

    private Integer quantity;
}