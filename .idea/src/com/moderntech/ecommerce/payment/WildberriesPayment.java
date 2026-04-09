package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;

public class WildberriesPayment {
    private final Payment payment;

    public WildberriesPayment(Order order) {
        this.payment = new Payment(order);
    }

    public boolean payWithDigitalWallet(String walletId, String walletType) {
        System.out.println("\nОПЛАТА ЧЕРЕЗ WILDBERRIES");
        payment.setPaymentMethod(new DigitalWalletPayment(walletId, walletType));
        return payment.executePayment();
    }
}