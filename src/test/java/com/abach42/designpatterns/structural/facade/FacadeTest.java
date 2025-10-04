package com.abach42.designpatterns.structural.facade;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FacadeTest {

    @Test
    void testOrderFacadeSuccess() {
        OrderFacade facade = new OrderFacade();

        String result = facade.placeOrder("Laptop", 2, 2000.0);
        assertEquals("Shipping 2 units of Laptop", result);
    }

    @Test
    void testOrderFacadeStockFailure() {
        OrderFacade facade = new OrderFacade();

        String result = facade.placeOrder("Laptop", 0, 2000.0);
        assertEquals("Order failed: not enough stock", result);
    }

    @Test
    void testOrderFacadePaymentFailure() {
        OrderFacade facade = new OrderFacade();

        String result = facade.placeOrder("Laptop", 2, 0.0);
        assertEquals("Order failed: payment declined", result);
    }
}
