package com.abach42.designpatterns.behavioral.observer.simple;

public class CalculateDistanceObserver extends AbstractObserver {

    public CalculateDistanceObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        RouteEntity entity = this.subject.getStateEntity();
        entity.setDistance(entity.calculateDistance());
    }
}
