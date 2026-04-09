package com.moderntech.ecommerce.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
    private final Map<String, CartItem> items;
    private static final BigDecimal VAT_RATE = new BigDecimal("0.20");

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(Product product, int quantity) {
        String productId = product.id();
        if (items.containsKey(productId)) {
            CartItem existing = items.get(productId);
            int newQuantity = existing.quantity() + quantity;
            if (newQuantity > product.stock()) {
                throw new IllegalStateException("Недостаточно товара на складе");
            }
            items.put(productId, new CartItem(product, newQuantity));
        } else {
            if (quantity > product.stock()) {
                throw new IllegalStateException("Недостаточно товара на складе");
            }
            items.put(productId, new CartItem(product, quantity));
        }
    }

    public void removeItem(String productId) {
        items.remove(productId);
    }

    public void updateQuantity(String productId, int quantity) {
        CartItem item = items.get(productId);
        if (item == null) {
            throw new IllegalArgumentException("Товар не найден в корзине");
        }
        if (quantity <= 0) {
            items.remove(productId);
        } else if (quantity <= item.product().stock()) {
            items.put(productId, new CartItem(item.product(), quantity));
        } else {
            throw new IllegalStateException("Недостаточно товара на складе");
        }
    }

    public BigDecimal getTotal() {
        return items.values().stream()
                .map(CartItem::getSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalWithVAT() {
        return items.values().stream()
                .map(CartItem::getSubtotalWithVAT)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getVATAmount() {
        return getTotalWithVAT().subtract(getTotal());
    }

    public List<CartItem> getItems() {
        return new ArrayList<>(items.values());
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }

    public void displayCart() {
        if (isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        System.out.println("\n=== СОДЕРЖИМОЕ КОРЗИНЫ ===");
        for (CartItem item : getItems()) {
            System.out.printf("%s x%d = %.2f ₽ (с НДС: %.2f ₽)%n",
                    item.product().name(),
                    item.quantity(),
                    item.getSubtotal(),
                    item.getSubtotalWithVAT());
        }
        System.out.printf("Итого без НДС: %.2f ₽%n", getTotal());
        System.out.printf("НДС (20%%): %.2f ₽%n", getVATAmount());
        System.out.printf("Итого с НДС: %.2f ₽%n", getTotalWithVAT());
    }
}