package dev.portfolio.order.consumer;

import dev.portfolio.events.InventoryReservationResultEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class InventoryReservationResultConsumer {
    @KafkaListener(topics = "inventory.reservation-result", groupId = "order-service")
    public void onReservationResult(InventoryReservationResultEvent event) {
        // TODO: apply a valid order state transition idempotently.
        // TODO: initiate the payment step only after successful reservation.
    }
}
