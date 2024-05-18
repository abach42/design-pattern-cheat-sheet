package com.abach42.designpatterns.unit.behavioral.mediator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.mediator.ConcretePolishColleague;
import com.abach42.designpatterns.behavioral.mediator.ConcreteGermanColleague;
import com.abach42.designpatterns.behavioral.mediator.Mediator;

public class MediatorTest {

    @Test
    @DisplayName("Mediator should send messages to all and receive it")
    public void testMediator() {
        Mediator mediator = new Mediator();

        ConcreteGermanColleague germanColleague = new ConcreteGermanColleague(mediator);
        ConcretePolishColleague polishColleague = new ConcretePolishColleague(mediator);

        mediator.addColleague(germanColleague);
        mediator.addColleague(polishColleague);

        germanColleague.send("Schönes Wetter!");
        polishColleague.send("ładna pogoda!");

        assertEquals("Witaj świecie: Schönes Wetter!", polishColleague.getLastReceivedMessage());
        assertEquals("Hallo Welt: ładna pogoda!", germanColleague.getLastReceivedMessage());
    }
}