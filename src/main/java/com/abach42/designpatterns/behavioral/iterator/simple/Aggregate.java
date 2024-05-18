package com.abach42.designpatterns.behavioral.iterator.simple;

import java.util.Iterator;

public interface Aggregate<T> {
    Iterator<T> createIterator();
}