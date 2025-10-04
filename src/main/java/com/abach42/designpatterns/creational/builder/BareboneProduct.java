package com.abach42.designpatterns.creational.builder;

public record BareboneProduct(String cpu, int ramSize, int hardDiskSize, String cooler) {

    @Override
    public String toString() {
        return "BareboneProduct[" +
                "cpu=" + cpu +
                ",ramSize=" + ramSize +
                ",hardDiskSize=" + hardDiskSize +
                ",cooler=" + cooler +
                "]";
    }
}