package com.abach42.designpatterns.behavioral.builder;

public class BareboneConcreteBuilder extends Builder{
    @Override
    public Builder addCooler() {
        this.cooler = Builder.CoolerType.SMALL;

        return this;
    }

    public BareboneProduct build() {
        return new BareboneProduct(cpu, ramSize, hardDiskSize, cooler.toString());
    }
}