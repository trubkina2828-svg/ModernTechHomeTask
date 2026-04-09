package com.moderntech.ecommerce.models;

import com.moderntech.ecommerce.enums.ProductCategory;
import java.math.BigDecimal;

public record Product(String id, String name, ProductCategory category,
                      BigDecimal price, int stock) {

    public Product {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Количество не может быть отрицательным");
        }
    }

    public boolean isInStock() {
        return stock > 0;
    }

    public BigDecimal getPriceWithVAT() {
        // НДС 20%
        return price.multiply(new BigDecimal("1.2"));
    }

    @Override
    public String toString() {
        return String.format("[%s] %s - %s | Цена: %.2f ₽ | В наличии: %d",
                id, name, category, price, stock);
    }
}