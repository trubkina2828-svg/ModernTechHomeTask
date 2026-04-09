package com.moderntech.ecommerce.payment;

import java.math.BigDecimal;
import java.util.UUID;

public final class CreditCardPayment implements PaymentMethod {
    private final String cardNumber;
    private final String cardHolder;
    private final String expiryDate;
    private PaymentStatus status;
    private String transactionId;

    public CreditCardPayment(String cardNumber, String cardHolder, String expiryDate) {
        this.cardNumber = maskCardNumber(cardNumber);
        this.cardHolder = cardHolder;
        this.expiryDate = expiryDate;
        this.status = PaymentStatus.PENDING;
    }

    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() >= 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return "****";
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        this.status = PaymentStatus.PROCESSING;
        this.transactionId = UUID.randomUUID().toString().substring(0, 8);

        boolean success = Math.random() > 0.1;

        if (success) {
            this.status = PaymentStatus.SUCCESS;
            System.out.printf("Банковская карта %s: списано %.2f ₽",
                    cardNumber, amount, transactionId);
        } else {
            this.status = PaymentStatus.FAILED;
            System.out.printf("Ошибка оплаты банковской картой %s%n", cardNumber);
        }
        return success;
    }

    @Override
    public String getMethodName() {
        return String.format("Банковская карта (%s, %s)", cardNumber, cardHolder);
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }
}