package com.moderntech.ecommerce.models;

import com.moderntech.ecommerce.enums.OrderStatus;
import com.moderntech.ecommerce.payment.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final Customer customer;
    private final List<OrderItem> items;
    private final LocalDateTime orderDate;
    private OrderStatus status;
    private BigDecimal totalAmount;
    private BigDecimal totalAmountWithVAT;
    private String paymentMethod;
    private PaymentStatus paymentStatus;

    public Order(Customer customer, ShoppingCart cart) {
        this.id = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        this.customer = customer;
        this.items = new ArrayList<>();
        for (CartItem cartItem : cart.getItems()) {
            this.items.add(new OrderItem(cartItem));
        }
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
        this.totalAmount = cart.getTotal();
        this.totalAmountWithVAT = cart.getTotalWithVAT();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public String getId() { return id; }
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
    public OrderStatus getStatus() { return status; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public BigDecimal getTotalAmountWithVAT() { return totalAmountWithVAT; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }

    public void setStatus(OrderStatus status) {
        OrderStatus oldStatus = this.status;
        this.status = status;
        System.out.printf("Статус заказа %s изменён: %s → %s%n",
                id, oldStatus, status);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
        System.out.printf("Статус платежа заказа %s: %s%n", id, paymentStatus);
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void displayOrderDetails() {
        System.out.printf("ЗАКАЗ №%s%n", id);
        System.out.printf("Покупатель: %s%n", customer.getName());
        System.out.printf("Статус заказа: %s%n", status);
        System.out.printf("Статус платежа: %s%n", paymentStatus);
        System.out.println("Товары:                                                       ");
        for (OrderItem item : items) {
            System.out.printf("   • %s x%d = %.2f ₽ (с НДС: %.2f ₽)%n",
                    item.productName(), item.quantity(),
                    item.getSubtotal(), item.getSubtotalWithVAT());
        }
        System.out.printf("Итого с НДС: %35.2f ₽%n", totalAmountWithVAT);
        if (paymentMethod != null) {
            System.out.printf("Способ оплаты: %34s%n", paymentMethod);
        }
    }
}