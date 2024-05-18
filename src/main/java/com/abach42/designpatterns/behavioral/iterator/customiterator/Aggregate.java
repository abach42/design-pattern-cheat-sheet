package com.abach42.designpatterns.behavioral.iterator.customiterator;

import java.util.Iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}