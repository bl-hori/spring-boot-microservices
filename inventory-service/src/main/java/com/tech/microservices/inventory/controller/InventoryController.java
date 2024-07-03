package com.tech.microservices.inventory.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.microservices.inventory.dto.InventoryResponse;
import com.tech.microservices.inventory.service.InventoryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    public List<InventoryResponse> isInStock(@PathVariable("sku-code") String skuCode) {

        return inventoryService.isInStock(Arrays.asList(skuCode.split("\\s*,\\s*")));
    }
}
