package com.abach42.designpatterns.structural.facade;

public class ShippingService {
    public String shipProduct(String product, int quantity) {
        return "Shipping " + quantity + " units of " + product;
    }
}
