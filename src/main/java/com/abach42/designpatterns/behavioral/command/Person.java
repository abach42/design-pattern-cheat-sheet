package com.abach42.designpatterns.behavioral.command;

public record Person(Long id, String name, Integer age) {

    public Person(String name, Integer age) {
        this(null, name, age);
    }

    public Person(Long id) {
        this(id, null, null);
    }
}
