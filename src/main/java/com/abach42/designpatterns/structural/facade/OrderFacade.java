package com.abach42.designpatterns.structural.facade;

public class OrderFacade {

    private final PaymentProcessor paymentProcessor;
    private final InventoryManager inventoryManager;
    private final ShippingService shippingService;

    public OrderFacade() {
        this.paymentProcessor = new PaymentProcessor();
        this.inventoryManager = new InventoryManager();
        this.shippingService = new ShippingService();
    }

    public String placeOrder(String product, int quantity, double amount) {
        if (!inventoryManager.checkStock(product, quantity)) {
            return "Order failed: not enough stock";
        }
        if (!paymentProcessor.processPayment(amount)) {
            return "Order failed: payment declined";
        }
        return shippingService.shipProduct(product, quantity);
    }
}
