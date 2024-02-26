package com.abach42.designpatterns.creational.abstractfactory;

public abstract class AbstractProductB {
    protected String id;

    public String getId() {
        return id;
    }

    public String toString() {
        return "Id:" + id;
    }
}