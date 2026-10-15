# E-commerce Order & Inventory Platform

A portfolio project for practicing production-minded Java backend engineering.
This repository contains service boundaries and infrastructure scaffolding only.
Business logic is intentionally left for you to implement.

## Services

- `order-service` — order API and order lifecycle.
- `inventory-service` — stock availability and reservation ownership.
- `payment-service` — payment workflow behind a provider-neutral abstraction (simulation only).
- `notification-service` — asynchronous notification workflow.
- `common-events` — shared event contracts.

## Architecture (target)

```text
Client
  |
  v
Order Service -----> order_db
  |  (order.created event via outbox)
  v
Kafka
  |                         |
  v                         v
Inventory Service     Notification Service
  |
  | inventory.reserved / inventory.rejected
  v
Kafka ---> Order Service ---> Payment Service
                   |
                   v
              Order status
```

This is a target architecture, not a completed workflow. Implement each stage incrementally.

## Prerequisites

- JDK 21
- Maven 3.9+
- Docker with Compose

## Start local infrastructure

```bash
docker compose up -d
```

PostgreSQL is exposed on `localhost:5432`; Kafka on `localhost:9092`.
The PostgreSQL init script creates a separate database for each service.

## Build and run

```bash
mvn clean verify
mvn -pl order-service spring-boot:run
mvn -pl inventory-service spring-boot:run
mvn -pl payment-service spring-boot:run
mvn -pl notification-service spring-boot:run
```

Run each service in a separate terminal. Initial Flyway migrations are intentionally TODOs,
so services with Flyway enabled need a valid migration before a successful startup.

## API outline

Initial order endpoint skeleton:
- `POST /api/v1/orders`

Add these endpoints as later milestones:
- `GET /api/v1/orders/{orderId}`
- `GET /api/v1/orders` with pagination/filtering
- `POST /api/v1/inventory/products`
- `GET /api/v1/inventory/products/{productId}`
- `POST /api/v1/inventory/reservations`
- Internal payment and operational endpoints as appropriate.

## Phased implementation plan

### Phase 1 — Order API and persistence
- Define Order and OrderItem domain models.
- Add Flyway schema, constraints, and indexes.
- Implement validation, global error responses, transactions, and DTO mapping.
- Add idempotent order creation and order status transitions.
- Test concurrent and duplicate requests.

### Phase 2 — Inventory correctness
- Create product stock records and reservation records.
- Reserve stock atomically and reject overselling.
- Handle multiple order items and reservation expiry.
- Add concurrency tests.

### Phase 3 — Kafka integration
- Define versioned event contracts and stable message keys.
- Implement transactional outbox publication.
- Implement idempotent consumers, retry/backoff, and dead-letter topics.
- Test duplicate, delayed, and out-of-order events.

### Phase 4 — Order workflow and saga
- Model order states explicitly.
- Coordinate order, inventory, and simulated payment steps.
- Define compensating actions, e.g. release stock after payment failure.
- Document timeout and partial-failure behavior.

### Phase 5 — Security and resilience
- Add Spring Security and JWT/OAuth2 resource-server configuration.
- Add authorization rules, rate limits, timeouts, circuit breakers, and safe fallbacks.
- Keep secrets outside source control.

### Phase 6 — Testing and observability
- Add unit, integration, Testcontainers, and contract tests.
- Add correlation IDs, structured logs, metrics, health checks, and distributed tracing.
- Create a failure-injection runbook.

### Phase 7 — Delivery and portfolio polish
- Add Dockerfiles and GitHub Actions CI.
- Add API collection, architecture diagrams, and architecture decision records.
- Load-test critical endpoints and document measured results.

## Engineering rules

- Keep business rules out of controllers.
- Do not expose JPA entities from APIs.
- Use database constraints as well as application checks for invariants.
- Use database migrations; do not rely on `ddl-auto=update`.
- Design event consumers for at-least-once delivery.
- Never commit credentials or real payment data.
- Payment integration in this portfolio is simulated; do not use real payment credentials.
