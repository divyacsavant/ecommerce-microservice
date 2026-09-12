package com.divya.product_service.controller;

import com.divya.product_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "INVENTORY-SERVICE")
public interface InventoryClient {

    @GetMapping(
            "/inventory/{productId}")
    InventoryResponse getInventory(
            @PathVariable
            Long productId);
}