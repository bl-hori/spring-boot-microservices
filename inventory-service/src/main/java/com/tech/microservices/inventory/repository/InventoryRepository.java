package com.tech.microservices.inventory.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.microservices.inventory.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
