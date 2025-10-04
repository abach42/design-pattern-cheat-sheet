package com.abach42.designpatterns.structural.facade;

public class InventoryManager {
    public boolean checkStock(String product, int quantity) {
        return quantity > 0 && product != null;
    }
}
