package com.tech.microservices.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tech.microservices.inventory.dto.InventoryResponse;
import com.tech.microservices.inventory.model.Inventory;
import com.tech.microservices.inventory.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryRepository inventoryRepository;

    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(this::buildInventoryResponse)
                .toList();
    }

    private InventoryResponse buildInventoryResponse(Inventory inventory) {
        return InventoryResponse.builder()
                .skuCode(inventory.getSkuCode())
                .isInStock(inventory.getQuantity() > 0)
                .build();
    }
}
