package com.divya.inventory_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryDto {

    private Long productId;

    private Integer quantity;
}
  