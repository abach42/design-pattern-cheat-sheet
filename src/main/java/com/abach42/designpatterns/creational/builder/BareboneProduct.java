package com.abach42.designpatterns.creational.builder;

public class BareboneProduct {
    private final String cpu;
    private final int ramSize;
    private final int hardDiskSize;
    private final String cooler;

    public BareboneProduct(String cpu, int ramSize, int hardDiskSize, String cooler) {
        this.cpu = cpu;
        this.ramSize = ramSize;
        this.hardDiskSize = hardDiskSize;
        this.cooler = cooler;
    }

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