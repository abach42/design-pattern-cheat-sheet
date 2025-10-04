package com.abach42.designpatterns.behavioral.observer.propertychange;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ObserverPropertyChangeTest {
    
    @Test
    @DisplayName("Observers listen and change routing information, distance and duration")
    public void testObserversListenAndChangeRoutingInformation() {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        AbstractObserver.createAndAttach(new CalculateDistanceObserver(subject));
        AbstractObserver.createAndAttach(new CalculateDurationObserver(subject));
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));
        subject.setRouteEntity(route);

        assertEquals(28.284271, route.getDistance(), 0.000001);
        assertEquals(5.656854, route.getDuration(), 0.000001);
    }

    @Test
    @DisplayName("Observers listen and change distance but not duration")
    public void testObserverListenAndChangePartly() {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        AbstractObserver.createAndAttach(new CalculateDistanceObserver(subject));
        CalculateDurationObserver durationObserver =  new CalculateDurationObserver(subject);
        subject.detachObserver(durationObserver);
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));
        subject.setRouteEntity(route);

        assertEquals(28.284271, route.getDistance(), 0.000001);
        assertEquals(0.0F, route.getDuration());
    }
}