package com.abach42.designpatterns.behavioral.observer.propertychange;

import java.beans.PropertyChangeListener;

public interface Subject {

    void setRouteEntity(RouteEntity routeEntity);

    RouteEntity getRouteEntity();

    void attachObserver(PropertyChangeListener listener);

    void detachObserver(PropertyChangeListener listener);
}