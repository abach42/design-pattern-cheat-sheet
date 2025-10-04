package com.abach42.designpatterns.creational.builder;

public record TowerProduct(String cpu, int ramSize, int hardDiskSize, String cooler) {

    @Override
    public String toString() {
        return "TowerProduct[" +
                "cpu=" + cpu +
                ",ramSize=" + ramSize +
                ",hardDiskSize=" + hardDiskSize +
                ",cooler=" + cooler +
                "]";
    }
}