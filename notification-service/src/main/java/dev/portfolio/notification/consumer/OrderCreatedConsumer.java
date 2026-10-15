package dev.portfolio.notification.consumer;

import dev.portfolio.events.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderCreatedConsumer {
    @KafkaListener(topics = "order.created", groupId = "notification-service")
    public void onOrderCreated(OrderCreatedEvent event) {
        // TODO: persist notification intent and implement a provider-neutral delivery abstraction.
        // TODO: make delivery idempotent and observable; use a fake provider in tests.
    }
}
