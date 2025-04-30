package com.medlab.orderservice.web.controllers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
class RabbitMQListener {
    @RabbitListener(queues = "${orders.new-orders-queue}")
    public void handleNewOrder(MyPayload payload) {
        System.out.println("New order: " + payload.content());
    }

    @RabbitListener(queues = "${orders.delivered-orders-queue}")
    public void handleDeliveredOrder(MyPayload payload) {
        System.out.println("Delivered order: " + payload.content());
    }

    @RabbitListener(queues = "${orders.cancelled-orders-queue}")
    public void handleOrderCancelled(MyPayload payload) {
        System.out.println("Order cancelled: " + payload.content());
    }

    @RabbitListener(queues = "${orders.error-orders-queue}")
    public void handleOrderError(MyPayload payload) {
        System.out.println("Order error: " + payload.content());
    }
}
