package com.divya.inventory_service.service;

import com.divya.inventory_service.dto.InventoryDto;
import com.divya.inventory_service.entity.Inventory;
import com.divya.inventory_service.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository
            repository;

    public InventoryDto createInventory(
            InventoryDto dto) {

        Inventory inventory =
                Inventory.builder()
                        .productId(
                                dto.getProductId())
                        .quantity(
                                dto.getQuantity())
                        .build();

        Inventory saved =
                repository.save(
                        inventory);

        return InventoryDto.builder()
                .productId(
                        saved.getProductId())
                .quantity(
                        saved.getQuantity())
                .build();
    }

    public InventoryDto getInventory(
            Long productId) {

        Inventory inventory =
                repository.findByProductId(
                                productId)
                        .orElseThrow();

        return InventoryDto.builder()
                .productId(
                        inventory.getProductId())
                .quantity(
                        inventory.getQuantity())
                .build();
    }
}