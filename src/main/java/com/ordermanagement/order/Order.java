package com.ordermanagement.order;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    private Long orderId;

    private String customerName;
    private String product;
    private Integer quantity;
    private Double totalPrice;
    private String paymentStatus; // e.g., PENDING, PROCESSED, COMPLETED
    private LocalDateTime orderDate;

    // Default constructor (required by JPA)
    public Order() {
    }

    // Constructor with orderId (for testing or special cases)
    public Order(Long orderId, String customerName, String product, Integer quantity, Double totalPrice, String paymentStatus, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.orderDate = orderDate;
    }

    // Constructor without orderId (for normal use)
    public Order(String customerName, String product, Integer quantity, Double totalPrice, String paymentStatus, LocalDateTime orderDate) {
        this.customerName = customerName;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.paymentStatus = paymentStatus;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }
}