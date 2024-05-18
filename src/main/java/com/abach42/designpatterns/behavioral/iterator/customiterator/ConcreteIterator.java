package com.abach42.designpatterns.behavioral.iterator.customiterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ConcreteIterator<T> implements Iterator<T>{
    private final List<T> items;
    private int position;

    public ConcreteIterator(List<T> items) {
        this.items = items;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        return items.get(position++);
    }
}
