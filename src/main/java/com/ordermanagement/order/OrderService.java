package com.ordermanagement.order;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getOrders() {
        return orderRepository.findAll();
    }

    public void addNewOrder(Order order) {
        Optional<Order> orderByOrderId = orderRepository.findOrderByOrderId(order.getOrderId());
        if(orderByOrderId.isPresent()) {
            throw new IllegalStateException("Order already exists");
        }
        orderRepository.save(order);
    }

    public void deleteOrder(Long orderId) {
        boolean exists = orderRepository.existsById(orderId);
        if(!exists) {
            throw new IllegalStateException("Order with id " + orderId + " does not exist.");
        }
        orderRepository.deleteById(orderId);
    }

    @Transactional
    public void updateOrder(Long orderId, String customerName, Integer quantity) {
        Order existingOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalStateException("Order with id " + orderId + " does not exist."));

        // Update customerName if provided and different from the existing value
        if (customerName != null && !customerName.isEmpty() && !customerName.equals(existingOrder.getCustomerName())) {
            existingOrder.setCustomerName(customerName);
        }

        // Update quantity if provided and different from the existing value
        if (quantity != null && !quantity.equals(existingOrder.getQuantity())) {
            existingOrder.setQuantity(quantity);
        }

        orderRepository.save(existingOrder);
    }
}
