package com.abach42.designpatterns.behavioral.observer.propertychange;

public class CalculateDurationObserver extends AbstractObserver {

    private static final int SPEED = 5;

    public CalculateDurationObserver(ConcreteRoutingSubject subject) {
        super(subject);

        this.visitor = (RouteEntity routeEntity) ->
                routeEntity.setDuration(calculateDuration(routeEntity));
    }

    // does not read the distance another observer wrote: the order of observers must not matter
    private float calculateDuration(RouteEntity entity) {
        return (float) entity.calculateDistance() / SPEED;
    }
}
