package com.abach42.designpatterns.behavioral.builder;

public class TowerProduct {
    private final String cpu;
    private final int ramSize;
    private final int hardDiskSize;
    private final String cooler;

    public TowerProduct(String cpu, int ramSize, int hardDiskSize, String cooler) {
        this.cpu = cpu;
        this.ramSize = ramSize;
        this.hardDiskSize = hardDiskSize;
        this.cooler = cooler;
    }

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