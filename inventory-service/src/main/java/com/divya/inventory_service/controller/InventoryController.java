package com.divya.inventory_service.controller;

import com.divya.inventory_service.dto.InventoryDto;
import com.divya.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService
            inventoryService;

    @PostMapping
    public InventoryDto createInventory(
            @RequestBody
            InventoryDto dto) {

        return inventoryService
                .createInventory(dto);
    }

    @GetMapping("/{productId}")
    public InventoryDto getInventory(
            @PathVariable
            Long productId) {

        return inventoryService
                .getInventory(productId);
    }
}

