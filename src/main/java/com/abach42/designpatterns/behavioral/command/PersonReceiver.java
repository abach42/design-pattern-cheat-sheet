package com.abach42.designpatterns.behavioral.command;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

/**
 * Receiver: knows how to carry out the operations behind a request. It knows nothing about commands.
 */
public class PersonReceiver {

    private final Map<Long, Person> persons = new LinkedHashMap<>();
    private long lastId = 0L;

    public Person createPerson(String name, Integer age) {
        lastId++;
        Person person = new Person(lastId, name, age);
        persons.put(lastId, person);
        return person;
    }

    public void updatePerson(Person person) {
        if (person.id() == null) {
            throw new IllegalArgumentException("Person needs an Id to be updated");
        }
        requireExisting(person.id());
        persons.put(person.id(), person);
    }

    public void deletePerson(long id) {
        requireExisting(id);
        persons.remove(id);
    }

    public List<Person> getPersons() {
        return List.copyOf(persons.values());
    }

    private void requireExisting(long id) {
        if (!persons.containsKey(id)) {
            throw new NoSuchElementException("No person with Id " + id);
        }
    }
}
