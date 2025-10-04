package com.abach42.designpatterns.behavioral.observer.simple;

import java.util.ArrayList;
import java.util.List;

public class ConcreteRoutingSubject implements Subject {

    private final List<AbstractObserver> observers = new ArrayList<>();
    private RouteEntity entity;
    private int entityHashCode = 0;

    @Override
    public void attachObserver(AbstractObserver observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(AbstractObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer -> observer.update());
    }

    public void setStateEntity(RouteEntity entity) {
        this.entity = entity;

        if (entityHashCode != entity.hashCode()) {
            notifyObservers();
            entityHashCode = entity.hashCode();
        }
    }

    public RouteEntity getStateEntity() {
        return entity;
    }
}