package com.moderntech.ecommerce.models;

import java.math.BigDecimal;

public record OrderItem(String productId, String productName,
                        int quantity, BigDecimal priceAtOrder,
                        BigDecimal priceWithVATAtOrder) {

    public OrderItem(CartItem cartItem) {
        this(
                cartItem.product().id(),
                cartItem.product().name(),
                cartItem.quantity(),
                cartItem.product().price(),
                cartItem.product().getPriceWithVAT()
        );
    }

    public BigDecimal getSubtotal() {
        return priceAtOrder.multiply(BigDecimal.valueOf(quantity));
    }

    public BigDecimal getSubtotalWithVAT() {
        return priceWithVATAtOrder.multiply(BigDecimal.valueOf(quantity));
    }
}