package com.abach42.designpatterns.behavioral.observer.propertychange;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.function.Consumer;

public abstract class AbstractObserver implements PropertyChangeListener {

    protected Subject subject;
    protected RouteEntity entity;
    protected Consumer<RouteEntity> visitor;

    public AbstractObserver(Subject subject) {
        this.subject = subject;
        this.entity = this.subject.getRouteEntity();
    }

    public static <T extends AbstractObserver> T createAndAttach(T observer) {
        observer.subject.attachObserver(observer);
        return observer;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        String subjectName = subject.getClass().getName();

        if (subjectName.equals(evt.getPropertyName())) {
            visitor.accept((RouteEntity) evt.getNewValue());
        }
    }
}