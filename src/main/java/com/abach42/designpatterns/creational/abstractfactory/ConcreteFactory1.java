package com.abach42.designpatterns.creational.abstractfactory;

public class ConcreteFactory1 implements AbstractFactory {
    
    public AbstractProductA createProductA() {
        return new ConcreteProductA1();
    }

    public AbstractProductB createProductB() {
        return new ConcreteProductB1();
    }
}

