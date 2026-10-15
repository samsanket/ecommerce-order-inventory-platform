package dev.portfolio.events;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

/**
 * Event contract only. Add schema versioning and compatibility policy as an exercise.
 * Consider whether prices should be carried as snapshots in each item.
 */
public record OrderCreatedEvent(
        UUID eventId,
        UUID orderId,
        String customerReference,
        List<OrderItemEvent> items,
        Instant occurredAt
) {
    public record OrderItemEvent(UUID productId, int quantity) {}
}
