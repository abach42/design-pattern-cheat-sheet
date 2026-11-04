package com.abach42.designpatterns.behavioral.command;

import java.security.InvalidParameterException;
import java.util.LinkedHashSet;

public class PersonSetReceiver extends LinkedHashSet<Person> {

    public void addPerson(Person person) {
        add(person);
    }

    public Long getNextId() {
        if (size() == 0) {
            return 1L;
        }

        return getLast().id() + 1L;
    }

    public void deletePersonById(Person person) {
        if (null == person.id()) {
            throw new InvalidParameterException("Person needs an Id to be deleted");
        }

        removeIf(updatedPerson -> person.id().equals(updatedPerson.id()));
    }
}