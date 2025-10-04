package com.abach42.designpatterns.behavioral.observer.simple;

public interface Subject {

    void attachObserver(AbstractObserver observer);

    void detachObserver(AbstractObserver observer);

    void notifyObservers();

    void setStateEntity(RouteEntity entity);

    RouteEntity getStateEntity();
}
