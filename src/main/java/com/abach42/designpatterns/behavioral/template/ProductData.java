package com.abach42.designpatterns.behavioral.template;

public class ProductData extends Data {
    private final String name;
    private final double price;

    public ProductData(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}