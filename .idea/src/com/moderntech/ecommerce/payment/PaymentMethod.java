package com.moderntech.ecommerce.payment;

import java.math.BigDecimal;

public sealed interface PaymentMethod
        permits CreditCardPayment, DigitalWalletPayment, CashOnDelivery {

    boolean processPayment(BigDecimal amount);
    String getMethodName();
    PaymentStatus getStatus();
}