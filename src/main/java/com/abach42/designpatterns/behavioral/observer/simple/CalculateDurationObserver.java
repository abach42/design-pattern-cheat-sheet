package com.abach42.designpatterns.behavioral.observer.simple;

public class CalculateDurationObserver extends AbstractObserver {

    private static final int SPEED = 5;

    public CalculateDurationObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        RouteEntity entity = this.subject.getStateEntity();
        float duration = calculateDuration(entity);

        entity.setDuration(duration);
    }

    private float calculateDuration(RouteEntity entity) {
        float duration = (float) entity.getDistance() / SPEED;
        return duration;
    }
}