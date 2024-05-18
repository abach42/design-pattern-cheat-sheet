package com.abach42.designpatterns.behavioral.observer.propertychange;

public class CalculateDistanceObserver extends AbstractObserver {
    public CalculateDistanceObserver(ConcreteRoutingSubject subject) {
        super(subject);
        
        this.visitor = (RouteEntity routeEntity) -> {
            double calculatedDistance  = calculateDistance(routeEntity);
            routeEntity.setDistance(calculatedDistance );
        };
    }

    private double calculateDistance(RouteEntity entity) {
       int deltaX = entity.getDestination().x - entity.getLocation().x;
       int deltaY = entity.getDestination().y - entity.getLocation().y;
       double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

       return distance;
    }
}