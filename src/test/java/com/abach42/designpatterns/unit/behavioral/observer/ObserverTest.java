package com.abach42.designpatterns.unit.behavioral.observer;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.observer.AbstractObserver;
import com.abach42.designpatterns.behavioral.observer.CalculateDistanceObserver;
import com.abach42.designpatterns.behavioral.observer.CalculateDurationObserver;
import com.abach42.designpatterns.behavioral.observer.ConcreteRoutingSubject;
import com.abach42.designpatterns.behavioral.observer.RouteEntity;

public class ObserverTest {
    @Test
    @DisplayName("Observers listen and change routing information, distance and duration")
    public void testObserversListenAndChangeRoutingInformation() {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        new CalculateDistanceObserver(subject);
        new CalculateDurationObserver(subject);
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));

        subject.setStateEntity(route);

        assertNotEquals(0.0, route.getDistance());
        assertNotEquals(0.0F, route.getDestination());
    }

    @Test
    @DisplayName("Observers listen and change distance but not duration")
    public void testObserverListenAndChangePartly() {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        new CalculateDistanceObserver(subject);
        AbstractObserver durationObserver =  new CalculateDurationObserver(subject);
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));

        subject.detachObserver(durationObserver);
        subject.setStateEntity(route);

        assertNotEquals(0.0, route.getDistance());
        assertEquals(0.0F, route.getDuration());
    }
}