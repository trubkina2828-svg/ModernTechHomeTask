package com.moderntech.ecommerce.models;

import java.util.UUID;

public class Customer {
    private final String id;
    private final String name;
    private final String email;
    private ShoppingCart cart;

    public Customer(String name, String email) {
        this.id = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.email = email;
        this.cart = new ShoppingCart();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public ShoppingCart getCart() { return cart; }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public String toString() {
        return String.format("Покупатель: %s (ID: %s, Email: %s)", name, id, email);
    }
}