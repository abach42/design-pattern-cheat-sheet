package com.abach42.designpatterns.behavioral.observer.simple;

public class CalculateDurationObserver extends AbstractObserver {

    private static final int SPEED = 5;

    public CalculateDurationObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        RouteEntity entity = this.subject.getStateEntity();
        entity.setDuration(calculateDuration(entity));
    }

    // does not read the distance another observer wrote: the order of observers must not matter
    private float calculateDuration(RouteEntity entity) {
        return (float) entity.calculateDistance() / SPEED;
    }
}
