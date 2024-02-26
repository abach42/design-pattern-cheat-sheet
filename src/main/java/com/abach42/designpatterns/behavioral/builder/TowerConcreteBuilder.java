package com.abach42.designpatterns.behavioral.builder;

public class TowerConcreteBuilder extends Builder{
    @Override
    public Builder addCooler() {
        this.cooler = Builder.CoolerType.LARGE;

        return this;
    }

    public TowerProduct build() {
        return new TowerProduct(cpu, ramSize, hardDiskSize, cooler.toString());
    }
}