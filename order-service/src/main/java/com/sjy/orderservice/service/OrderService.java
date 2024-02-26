package com.sjy.orderservice.service;

import com.sjy.orderservice.dto.OrderDto;
import com.sjy.orderservice.entity.Order;

public interface OrderService {
    OrderDto createOrder(OrderDto orderDetails);
    OrderDto getOrderByOrderId(String orderId);
    Iterable<Order> getOrdersByUserId(String userId);
}
