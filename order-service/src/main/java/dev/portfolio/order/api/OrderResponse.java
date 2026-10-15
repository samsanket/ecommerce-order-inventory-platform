package dev.portfolio.order.api;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OrderResponse(
        UUID orderId,
        String status,
        BigDecimal totalAmount,
        String currency,
        Instant createdAt,
        List<OrderLineResponse> items
) {
    public record OrderLineResponse(UUID productId, int quantity, BigDecimal unitPrice) {}
}
