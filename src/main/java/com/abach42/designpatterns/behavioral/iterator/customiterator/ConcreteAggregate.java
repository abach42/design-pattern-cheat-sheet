package com.abach42.designpatterns.behavioral.iterator.customiterator;

import java.util.Iterator;
import java.util.List;

public class ConcreteAggregate<T> implements Aggregate<T> {

    private final List<T> items;

    public ConcreteAggregate(List<T> items) {
        this.items = items;
    }

    @Override
    public Iterator<T> createIterator() {
        return new ConcreteIterator<>(items);
    }
}