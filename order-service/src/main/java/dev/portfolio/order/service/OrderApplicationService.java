package dev.portfolio.order.service;

import dev.portfolio.order.api.CreateOrderRequest;
import dev.portfolio.order.api.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public class OrderApplicationService {
    public OrderResponse create(CreateOrderRequest request) {
        // TODO: implement order creation, pricing policy, idempotency, and persistence.
        // TODO: define the initial status and when the order.created event is emitted.
        // Do not call inventory or payment synchronously from the controller.
        throw new UnsupportedOperationException("Implement order creation");
    }
}
