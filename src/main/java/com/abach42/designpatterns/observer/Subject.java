package com.abach42.designpatterns.observer;

public interface Subject {
    public void attachObserver(AbstractObserver observer);
    public void detachObserver(AbstractObserver observer);
    public void notifyObservers();
    public void setStateEntity(RouteEntity entity);
    public RouteEntity getStateEntity();
}
