package com.abach42.designpatterns.unit.behavioral.observer.simple;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.observer.simple.AbstractObserver;
import com.abach42.designpatterns.behavioral.observer.simple.CalculateDistanceObserver;
import com.abach42.designpatterns.behavioral.observer.simple.CalculateDurationObserver;
import com.abach42.designpatterns.behavioral.observer.simple.ConcreteRoutingSubject;
import com.abach42.designpatterns.behavioral.observer.simple.RouteEntity;

public class ObserverSimpleTest {
    
    @Test
    @DisplayName("Observers listen and change routing information, distance and duration")
    public void testObserversListenAndChangeRoutingInformation() {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        new CalculateDistanceObserver(subject);
        new CalculateDurationObserver(subject);
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));
        subject.setStateEntity(route);

        assertEquals(28.284271, route.getDistance(), 0.000001);
        assertEquals(5.656854, route.getDuration(), 0.000001);
    }

    @Test
    @DisplayName("Observers listen and change distance but not duration")
    public void testObserverListenAndChangePartly() {
        ConcreteRoutingSubject subject = new ConcreteRoutingSubject();
        new CalculateDistanceObserver(subject);
        AbstractObserver durationObserver =  new CalculateDurationObserver(subject);
        subject.detachObserver(durationObserver);
        
        RouteEntity route = new RouteEntity("way home", new Point(0,0), new Point(20,20));
        subject.setStateEntity(route);

        assertEquals(28.284271, route.getDistance(), 0.000001);
        assertEquals(0.0F, route.getDuration());
    }
}