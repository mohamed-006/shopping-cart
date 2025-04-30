package com.medlab.orderservice.domain;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }

    public static OrderNotFoundException forOrderNumber(String OrderNumber) {
        return new OrderNotFoundException("Order with Number " + OrderNumber + " not found");
    }
}
