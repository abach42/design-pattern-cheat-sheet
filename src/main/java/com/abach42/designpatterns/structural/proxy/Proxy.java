package com.abach42.designpatterns.structural.proxy;

public class Proxy implements Subject {

    private final RealSubject realSubject;
    private boolean accessed = false;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public String getData() {
        accessed = true;
        return realSubject.getData();
    }

    public boolean wasAccessed() {
        return accessed;
    }
}
