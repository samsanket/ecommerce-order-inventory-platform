package dev.portfolio.events;

import java.time.Instant;
import java.util.UUID;

public record InventoryReservationResultEvent(
        UUID eventId,
        UUID orderId,
        String reservationReference,
        boolean reserved,
        String reasonCode,
        Instant occurredAt
) {}
