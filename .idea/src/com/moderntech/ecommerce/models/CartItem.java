package com.moderntech.ecommerce.models;
import java.math.BigDecimal;

public record CartItem(Product product, int quantity) {

    public CartItem {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Количество должно быть положительным");
        }
        if (quantity > product.stock()) {
            throw new IllegalArgumentException("Недостаточно товара на складе");
        }
    }

    public BigDecimal getSubtotal() {
        return product.price().multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getSubtotalWithVAT() {
        return product.getPriceWithVAT().multiply(BigDecimal.valueOf(quantity));
    }
}