package com.abach42.designpatterns.behavioral.chain.simple;

public abstract class AbstractHandler {
    protected AbstractHandler next;

    public void setNext(AbstractHandler next) {
        this.next = next;
    }

    public abstract void handle();

    protected void handleNext() {
        if(null != this.next) {
            this.next.handle();
        }
    }
}
