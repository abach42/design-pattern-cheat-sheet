package com.abach42.designpatterns.behavioral.iterator.customiterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CustomIteratorTest {

    @Test
    @DisplayName("should iterate on custom iterator")
    void testIteratorPattern() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        ConcreteAggregate<Integer> aggregate = new ConcreteAggregate<>(numbers);
        Iterator<Integer> iterator = aggregate.createIterator();

        List<Integer> result = new ArrayList<>();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }

        List<Integer> expected = List.of(1, 2, 3, 4, 5);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("should iterate if empty")
    void testIteratorException() {
        List<Integer> numbers = new ArrayList<>();
        ConcreteAggregate<Integer> aggregate = new ConcreteAggregate<>(numbers);
        Iterator<Integer> iterator = aggregate.createIterator();

        assertFalse(iterator.hasNext());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, iterator::next);
        assertEquals("No more elements", exception.getMessage());
    }
}