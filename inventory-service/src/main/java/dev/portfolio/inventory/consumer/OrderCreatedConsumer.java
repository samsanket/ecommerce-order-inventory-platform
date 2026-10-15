package dev.portfolio.inventory.consumer;

import dev.portfolio.events.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedConsumer {
    @KafkaListener(topics = "order.created", groupId = "inventory-service")
    public void onOrderCreated(OrderCreatedEvent event) {
        // TODO: validate event and reserve stock atomically.
        // TODO: enforce consumer idempotency and publish reservation result.
        // TODO: define retry and dead-letter handling.
    }
}
