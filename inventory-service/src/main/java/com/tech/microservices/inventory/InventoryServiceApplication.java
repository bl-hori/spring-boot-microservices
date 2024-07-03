package com.tech.microservices.inventory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.tech.microservices.inventory.model.Inventory;
import com.tech.microservices.inventory.repository.InventoryRepository;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
        return args -> {
            Inventory inventory = new Inventory();
            inventory.setSkuCode("iphone_12");
            inventory.setQuantity(100);
            inventoryRepository.save(inventory);

            inventory = new Inventory();
            inventory.setSkuCode("iphone_13");
            inventory.setQuantity(0);
            inventoryRepository.save(inventory);
        };
    }
}
