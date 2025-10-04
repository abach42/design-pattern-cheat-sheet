package com.abach42.designpatterns.structural.proxy;

public class RealSubject implements Subject {

    @Override
    public String getData() {
        return "real Values";
    }
}
