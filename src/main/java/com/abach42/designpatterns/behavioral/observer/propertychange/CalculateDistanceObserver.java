package com.abach42.designpatterns.behavioral.observer.propertychange;

public class CalculateDistanceObserver extends AbstractObserver {

    public CalculateDistanceObserver(ConcreteRoutingSubject subject) {
        super(subject);

        this.visitor = (RouteEntity routeEntity) ->
                routeEntity.setDistance(routeEntity.calculateDistance());
    }
}
