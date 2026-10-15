# Target Order Flow

1. Client submits an order with an idempotency key.
2. Order Service validates and persists the order and an outbox record atomically.
3. Outbox publisher emits `order.created`.
4. Inventory Service reserves all requested items atomically or rejects the reservation.
5. Inventory emits a reservation result.
6. Order Service transitions state and requests simulated payment after reservation succeeds.
7. Payment Service emits a payment result.
8. Order Service marks the order confirmed or initiates compensating inventory release.
9. Notification Service consumes relevant events and records notification outcomes.

These are intended milestones, not implemented behavior. Specify timeouts, duplicate handling,
event ordering, and compensation rules before implementing the full flow.
