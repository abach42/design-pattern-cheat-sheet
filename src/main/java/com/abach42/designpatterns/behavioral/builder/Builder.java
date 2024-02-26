package com.abach42.designpatterns.behavioral.builder;

public abstract class Builder {
    protected static enum CoolerType {
        SMALL, LARGE
    }

    protected String cpu;
    protected int ramSize;
    protected int hardDiskSize;
    protected CoolerType cooler;

    public abstract Builder addCooler();

    public Builder setCpu(String cpu) {
        this.cpu = cpu;

        return this;
    }

    public Builder setRamSize(int ramSize) {
        this.ramSize = ramSize;

        return this;
    }

    public Builder setHardDiskSize(int hardDiskSize) {
        this.hardDiskSize = hardDiskSize;

        return this;
    }
}