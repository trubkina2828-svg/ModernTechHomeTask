package com.moderntech.ecommerce.payment;

public enum PaymentStatus {
    PENDING("Ожидает оплаты"),
    PROCESSING("Обработка платежа"),
    SUCCESS("Оплачен успешно"),
    FAILED("Ошибка оплаты"),
    REFUNDED("Возврат средств");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}