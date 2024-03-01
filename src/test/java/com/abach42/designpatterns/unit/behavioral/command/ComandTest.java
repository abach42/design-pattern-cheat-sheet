package com.abach42.designpatterns.unit.behavioral.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.abach42.designpatterns.behavioral.command.CreatePersonCommand;
import com.abach42.designpatterns.behavioral.command.DeletePersonCommand;
import com.abach42.designpatterns.behavioral.command.Person;
import com.abach42.designpatterns.behavioral.command.PersonInvoker;
import com.abach42.designpatterns.behavioral.command.PersonSetReceiver;
import com.abach42.designpatterns.behavioral.command.UpdatePersonCommand;

public class ComandTest {
    PersonInvoker invoker;
    PersonSetReceiver list;

    @BeforeEach
    public void setUp() {
        invoker = new PersonInvoker();
        list = new PersonSetReceiver();
    }

    @Test
    @DisplayName("Should create a 'Person' element")
    public void testCreateCommand() {
        invoker.setCommand(new CreatePersonCommand(list, new Person("John", 62)));
        invoker.runCommand();

        Person expectedPerson = new Person(1L, "John", 62);
        Person actualPerson = list.getFirst();
        assertEquals(expectedPerson, actualPerson);
    }

    @Test
    @DisplayName("Should create multiple 'Person' elements")
    public void testCreateCommandCreateMultipleElements() {
        invoker.setCommand(new CreatePersonCommand(list, new Person("John", 62)));
        invoker.setCommand(new CreatePersonCommand(list, new Person("Peter", 43)));
        invoker.setCommand(new CreatePersonCommand(list, new Person("James", 21)));
        invoker.runCommand();

        assertEquals(3, list.size());
        assertEquals(1L, list.getFirst().getId());
        assertEquals(3L, list.getLast().getId());
    }

    @Test
    @DisplayName("Should update a 'Person' element")
    public void testUpdateElement() {
        invoker.setCommand(new CreatePersonCommand(list, new Person( "Saul", 62)));
        invoker.setCommand(new UpdatePersonCommand(list, new Person(1L, "Paul", 34)));
        invoker.runCommand();

        Person expectedPerson = new Person(1L, "Paul", 34);
        Person actualPerson = list.getFirst();
        assertEquals(expectedPerson, actualPerson);
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Should delete a 'Person' element")
    public void testDeleteElement() {
        invoker.setCommand(new CreatePersonCommand(list, new Person("Peter", 62)));
        invoker.setCommand(new DeletePersonCommand(list, new Person(1L)));
        invoker.runCommand();
    
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Should throw because Id missing")
    public void testDeletionWhithoutIdFails() {
        invoker.setCommand(new CreatePersonCommand(list, new Person("Peter", 62)));
        invoker.setCommand(new DeletePersonCommand(list, new Person(null)));

        assertThrows(InvalidParameterException.class, () -> invoker.runCommand());
    }
}    
