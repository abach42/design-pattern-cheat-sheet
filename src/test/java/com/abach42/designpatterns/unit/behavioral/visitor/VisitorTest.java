package com.abach42.designpatterns.unit.behavioral.visitor;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.visitor.Element;
import com.abach42.designpatterns.behavioral.visitor.ElephantElement;
import com.abach42.designpatterns.behavioral.visitor.LionElement;
import com.abach42.designpatterns.behavioral.visitor.ObjectStructure;
import com.abach42.designpatterns.behavioral.visitor.VeterinarianVisitor;
import com.abach42.designpatterns.behavioral.visitor.Visitor;
import com.abach42.designpatterns.behavioral.visitor.FeedingVisitor;

public class VisitorTest {
    ObjectStructure zoo;

    @BeforeEach
    public void setUp() {
        zoo = new ObjectStructure();
        zoo.addAnimal(new LionElement());
        zoo.addAnimal(new ElephantElement());
    }
    
    @Test
    @DisplayName("Should set isFedUp status to true on all animal element")
    public void testFeedAnimals() {
        Visitor feedingVisitor = new FeedingVisitor();
        zoo.visitAnimals(feedingVisitor);

        for (Element animal : zoo.getAnimals()) {
           assertTrue(animal.isFedUp());
        }
    }

    @Test
    @DisplayName("Should set isHealthChecked status to true on all animal element")
    public void testCareAnimals() {
        Visitor veterinarianVistitor = new VeterinarianVisitor();
        zoo.visitAnimals(veterinarianVistitor);

        for (Element animal : zoo.getAnimals()) {
           assertTrue(animal.isHealthChecked());
        }
    }
}