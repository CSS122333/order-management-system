package com.ordermanagement.order;

import com.ordermanagement.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class OrderConfig {

    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        System.out.println("CommandLineRunner executing...");
        return args -> {
            Order order1 = new Order(
                    "John Doe", // customerName
                    "Smart Thermostat", // product
                    2, // quantity
                    199.98, // totalPrice
                    "PENDING", // paymentStatus
                    LocalDateTime.of(2025, 1, 1, 10, 30) // Specific order date and time
            );

            Order order2 = new Order(
                    "Jane Smith", // customerName
                    "Smart Light Bulb", // product
                    4, // quantity
                    99.96, // totalPrice
                    "COMPLETED", // paymentStatus
                    LocalDateTime.of(2025, 1, 2, 14, 45) // Specific order date and time
            );

            orderRepository.saveAll(List.of(order1, order2));
            System.out.println("Test data inserted successfully!"); // Add logging
        };
    }
}
