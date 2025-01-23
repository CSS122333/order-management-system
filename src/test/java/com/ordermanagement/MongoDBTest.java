package com.ordermanagement;

import com.ordermanagement.document.Invoice;
import com.ordermanagement.repository.mongo.InvoiceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MongoDBTest {
    @Autowired
    InvoiceRepository invoiceRepository;

    @Test
    public void testInvoiceRepository() {
        Invoice invoice = new Invoice();
//        invoice.setId("1");
//        invoice.setCustomerId("1234");
//        invoice.setProductList(List.of("Orange", "Apple"));
    }
}
