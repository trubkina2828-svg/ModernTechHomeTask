package com.moderntech.ecommerce.payment;

import java.math.BigDecimal;
import java.util.UUID;

public final class DigitalWalletPayment implements PaymentMethod {
    private final String walletId;
    private final String walletType;
    private PaymentStatus status;
    private String transactionId;

    public DigitalWalletPayment(String walletId, String walletType) {
        this.walletId = maskWalletId(walletId);
        this.walletType = walletType;
        this.status = PaymentStatus.PENDING;
    }

    private String maskWalletId(String walletId) {
        if (walletId.length() >= 4) {
            return "***" + walletId.substring(walletId.length() - 4);
        }
        return "***";
    }

    @Override
    public boolean processPayment(BigDecimal amount) {
        this.status = PaymentStatus.PROCESSING;
        this.transactionId = UUID.randomUUID().toString().substring(0, 8);

        boolean success = Math.random() > 0.1;

        if (success) {
            this.status = PaymentStatus.SUCCESS;
            System.out.printf("Электронный кошелёк %s (%s): списано %.2f ₽",
                    walletType, walletId, amount, transactionId);
        } else {
            this.status = PaymentStatus.FAILED;
            System.out.printf("Ошибка оплаты через электронный кошелёк %s%n", walletType);
        }
        return success;
    }

    @Override
    public String getMethodName() {
        return String.format("Электронный кошелёк (%s, %s)", walletType, walletId);
    }

    @Override
    public PaymentStatus getStatus() {
        return status;
    }
}