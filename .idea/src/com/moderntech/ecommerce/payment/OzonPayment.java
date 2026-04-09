package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;
import java.math.BigDecimal;

public class OzonPayment {
    private final Payment payment;

    public OzonPayment(Order order) {
        this.payment = new Payment(order);
    }

    public boolean payWithCreditCard(String cardNumber, String cardHolder, String expiryDate) {
        System.out.println("\nОПЛАТА ЧЕРЕЗ OZON");
        payment.setPaymentMethod(new CreditCardPayment(cardNumber, cardHolder, expiryDate));
        return payment.executePayment();
    }

    public boolean payWithCashOnDelivery() {
        System.out.println("\nОПЛАТА ЧЕРЕЗ OZON");
        payment.setPaymentMethod(new CashOnDelivery());
        return payment.executePayment();
    }
}