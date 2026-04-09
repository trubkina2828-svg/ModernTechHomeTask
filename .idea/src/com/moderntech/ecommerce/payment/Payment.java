package com.moderntech.ecommerce.payment;

import com.moderntech.ecommerce.models.Order;
import java.math.BigDecimal;

public class Payment {
    private PaymentMethod paymentMethod;
    private Order order;

    public Payment(Order order) {
        this.order = order;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public boolean executePayment() {
        if (paymentMethod == null) {
            System.out.println("Способ оплаты не выбран!");
            return false;
        }

        BigDecimal amount = order.getTotalAmountWithVAT();
        System.out.printf("\nПлатеж на сумму %.2f ₽ через %s%n",
                amount, paymentMethod.getMethodName());

        boolean success = paymentMethod.processPayment(amount);

        if (success) {
            order.setPaymentStatus(paymentMethod.getStatus());
        } else {
            order.setPaymentStatus(PaymentStatus.FAILED);
        }

        return success;
    }
}