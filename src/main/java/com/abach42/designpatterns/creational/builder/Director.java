package com.abach42.designpatterns.creational.builder;

public class Director {
    public void constructBasicComputer(Builder builder) {
        builder.setCpu("Intel Core i3")
            .setRamSize(16)
            .setHardDiskSize(500)
            .addCooler();
    }

    public void constructGamingComputer(Builder builder) {
        builder.setCpu("Intel Core i9")
            .setRamSize(64)
            .setHardDiskSize(2000)
            .addCooler();
    }
}