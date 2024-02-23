package com.abach42.designpatterns.behavioral.observer;

import java.awt.Point;
import java.text.DecimalFormat;

/*
 * The Observer Pattern is a design pattern where an object (the subject) maintains a list of its dependents (observers) and notifies
 * them of any state changes. This allows for loose coupling between components,
 * making it easier to maintain and extend the system. It's commonly used in scenarios like GUI frameworks and event handling systems.
 */
public class AppObserver {
    public static void main(String[] args) {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        new CalculateDistanceObserver(subject);
        new CalculateDurationObserver(subject);
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));

        subject.setStateEntity(route);
        System.out.println(
            "You would have " 
            + new DecimalFormat("#0.00").format(route.getDuration()) 
            + " h to travel"
        );
    }
}
