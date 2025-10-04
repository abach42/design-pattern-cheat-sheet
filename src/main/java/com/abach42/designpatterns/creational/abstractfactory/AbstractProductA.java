package com.abach42.designpatterns.creational.abstractfactory;

public abstract class AbstractProductA {

    protected String name;

    public String getName() {
        return name;
    }

    public String toString() {
        return "Name:" + name;
    }
}