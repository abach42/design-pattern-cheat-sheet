package com.abach42.designpatterns.behavioral.observer.propertychange;

public class CalculateDurationObserver extends AbstractObserver {
    private static final int SPEED = 5; 

    public CalculateDurationObserver(ConcreteRoutingSubject subject) {
        super(subject);
        
        this.visitor = (RouteEntity routeEntity) -> {
            float calculatedDuration = calculateDuration(routeEntity);
            routeEntity.setDuration(calculatedDuration);
        };
    }

    private float calculateDuration(RouteEntity entity) {
        float duration = (float) entity.getDistance() / SPEED;
        return duration;
    }
}