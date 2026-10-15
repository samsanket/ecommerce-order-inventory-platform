package dev.portfolio.payment.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentRequestConsumer {
    @KafkaListener(topics = "payment.requested", groupId = "payment-service")
    public void onPaymentRequested(String payload) {
        // TODO: replace String with a versioned event contract.
        // TODO: implement a simulated payment provider behind an interface.
        // TODO: ensure duplicate requests cannot create duplicate payment attempts.
    }
}
