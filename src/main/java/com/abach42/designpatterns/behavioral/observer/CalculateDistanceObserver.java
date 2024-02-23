package com.abach42.designpatterns.behavioral.observer;

public class CalculateDistanceObserver extends AbstractObserver {
    public CalculateDistanceObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
       RouteEntity entity = this.subject.getStateEntity();
       double distance = calculateDistance(entity);

       entity.setDistance(distance);
    }

    private double calculateDistance(RouteEntity entity) {
       int deltaX = entity.getDestination().x - entity.getLocation().x;
       int deltaY = entity.getDestination().y - entity.getLocation().y;
       double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

       return distance;
    }
}