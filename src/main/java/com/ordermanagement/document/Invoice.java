package com.ordermanagement.document;

import jakarta.persistence.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "invoice")
public class Invoice {
    @Id
    private String id;
    private String orderId;
}
