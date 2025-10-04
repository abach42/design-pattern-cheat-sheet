package com.abach42.designpatterns.structural.facade;

public class PaymentProcessor {

    public boolean processPayment(double amount) {
        return amount > 0;
    }
}
