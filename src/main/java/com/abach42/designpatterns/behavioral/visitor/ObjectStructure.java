package com.abach42.designpatterns.behavioral.visitor;

import java.util.ArrayList;
import java.util.List;

public class ObjectStructure {

    private final List<Element> animals = new ArrayList<>();

    public void addAnimal(Element element) {
        animals.add(element);
    }

    public void visitAnimals(Visitor visitor) {
        animals.forEach(element -> element.accept(visitor));
    }

    public List<Element> getAnimals() {
        return animals;
    }
}