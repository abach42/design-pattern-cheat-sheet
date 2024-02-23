package com.abach42.designpatterns.behavioral.observer;

public abstract class AbstractObserver {
    protected Subject subject;

    public AbstractObserver(Subject subject) {
        subject.attachObserver(this);
        this.subject = subject;
    }

    public abstract void update();
}
