package com.moderntech.ecommerce.enums;

public enum ProductCategory {
    SMARTPHONE("Смартфоны"),
    LAPTOP("Ноутбуки"),
    TABLET("Планшеты"),
    ACCESSORY("Аксессуары"),
    CAMERA("Фототехника");

    private final String displayName;

    ProductCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}