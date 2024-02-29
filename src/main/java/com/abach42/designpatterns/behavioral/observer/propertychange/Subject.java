package com.abach42.designpatterns.behavioral.observer.propertychange;

import java.beans.PropertyChangeListener;

public interface Subject {
    public void setRouteEntity(RouteEntity routeEntity);
    public RouteEntity getRouteEntity();
    public void attachObserver(PropertyChangeListener listener);
    public void detachObserver(PropertyChangeListener listener);
}