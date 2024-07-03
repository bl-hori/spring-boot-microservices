package com.tech.microservices.order.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.tech.microservices.order.dto.OrderLineItemDto;
import com.tech.microservices.order.dto.OrderRequest;
import com.tech.microservices.order.model.Order;
import com.tech.microservices.order.model.OrderLineItem;
import com.tech.microservices.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> orderLineItemList = orderRequest.getOrderLineItemList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setOrderLineItemList(orderLineItemList);

        orderRepository.save(order);
    }

    private OrderLineItem mapToDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        orderLineItem.setPrice(orderLineItemDto.getPrice());

        return orderLineItem;
    }
}
