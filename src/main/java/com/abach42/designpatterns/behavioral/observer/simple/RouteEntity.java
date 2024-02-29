package com.abach42.designpatterns.behavioral.observer.simple;

import java.awt.Point;
import java.util.Objects;

public class RouteEntity {
    private String name;
    private Point location;
    private Point destination;
    private double distance = 0.0;
    private float duration = 0.0F;

    public RouteEntity(String name, Point location, Point destination) {
        this.name = name;
        this.location = location;
        this.destination = destination;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Point getDestination() {
        return destination;
    }

    public void setDestination(Point destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

        public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.location, this.destination);
    }
}
