package com.abach42.designpatterns.behavioral.observer.propertychange;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ConcreteRoutingSubject implements Subject {
    private RouteEntity routeEntity;
    private final PropertyChangeSupport propertyChangeSupport;

    public ConcreteRoutingSubject() {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    @Override
    public void setRouteEntity(RouteEntity routeEntity) {
        RouteEntity oldValue = this.routeEntity;
        this.routeEntity = routeEntity;
        String subjectName = this.getClass().getName();

        propertyChangeSupport.firePropertyChange(subjectName, oldValue, routeEntity);
    }

    @Override
    public RouteEntity getRouteEntity() {
        return this.routeEntity;
    }

    @Override
    public void attachObserver(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    @Override
    public void detachObserver(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}