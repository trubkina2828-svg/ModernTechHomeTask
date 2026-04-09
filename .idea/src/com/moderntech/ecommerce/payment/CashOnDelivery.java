package com.moderntech.ecommerce.payment;

import java.math.BigDecimal;

public final class CashOnDelivery implements PaymentMethod {
    private PaymentStatus status;

    public CashOnDelivery() {
        this.status = PaymentStatus.PENDING;
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        this.status = PaymentStatus.PROCESSING;

        System.out.printf("Наложенный платёж: сумма %.2f ₽ будет оплачена при получении%n", amount);
        this.status = PaymentStatus.SUCCESS;
        return true;
    }

    @Override
    public String getMethodName() {
        return "Наложенный платёж (оплата при получении)";
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }
}