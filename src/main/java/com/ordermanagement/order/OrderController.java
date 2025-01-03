package com.ordermanagement.order;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/order")
//http://localhost:8080/api/v1/order
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public void createNewOrder(@RequestBody Order order) {
        orderService.addNewOrder(order);
//        ###
//        POST http://localhost:8080/api/v1/order
//        Content-Type: application/json
//
//        {
//            "orderId": 1,
//                "customerName": "Colin",
//                "product": "Smart Thermostat",
//                "quantity": 2,
//                "totalPrice": 199.98,
//                "paymentStatus": "PENDING",
//                "orderDate": "2025-01-01T10:30:00"
//        }
    }

    @DeleteMapping(path = "{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId) {
        orderService.deleteOrder(orderId);

//        ### Define a variable for orderId
//        @orderId = 1
//
//        ### DELETE Request: Delete an order by ID
//        DELETE http://localhost:8080/api/v1/order/{{orderId}}
    }


    @PutMapping(path = "{orderId}")
    public void updateOrder(
            @PathVariable("orderId") Long orderId,
            @RequestParam(required = false) String customerName,
            @RequestParam(required = false) Integer quantity
    ) {
        orderService.updateOrder(orderId, customerName, quantity);
    }

}
