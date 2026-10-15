package dev.portfolio.order.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.List;
import java.util.UUID;

public record CreateOrderRequest(
        @NotBlank String customerReference,
        @NotBlank String idempotencyKey,
        @NotEmpty List<@Valid OrderItemRequest> items
) {
    public record OrderItemRequest(
            @NotNull UUID productId,
            @Positive int quantity
    ) {}
}
