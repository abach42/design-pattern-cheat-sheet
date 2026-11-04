package com.abach42.designpatterns.behavioral.command;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandTest {

    private PersonInvoker invoker;
    private PersonReceiver receiver;

    @BeforeEach
    void setUp() {
        invoker = new PersonInvoker();
        receiver = new PersonReceiver();
    }

    @Test
    @DisplayName("Should create a 'Person' element")
    void testCreateCommand() {
        invoker.addCommand(new CreatePersonCommand(receiver, "John", 62));
        invoker.runCommands();

        assertEquals(List.of(new Person(1L, "John", 62)), receiver.getPersons());
    }

    @Test
    @DisplayName("Should create multiple 'Person' elements with ascending Ids")
    void testCreateCommandCreateMultipleElements() {
        invoker.addCommand(new CreatePersonCommand(receiver, "John", 62));
        invoker.addCommand(new CreatePersonCommand(receiver, "Peter", 43));
        invoker.addCommand(new CreatePersonCommand(receiver, "James", 21));
        invoker.runCommands();

        assertEquals(
                List.of(
                        new Person(1L, "John", 62),
                        new Person(2L, "Peter", 43),
                        new Person(3L, "James", 21)),
                receiver.getPersons());
    }

    @Test
    @DisplayName("Should update a 'Person' element in place")
    void testUpdateElement() {
        invoker.addCommand(new CreatePersonCommand(receiver, "Saul", 62));
        invoker.addCommand(new CreatePersonCommand(receiver, "Peter", 43));
        invoker.addCommand(new UpdatePersonCommand(receiver, new Person(1L, "Paul", 34)));
        invoker.runCommands();

        assertEquals(
                List.of(new Person(1L, "Paul", 34), new Person(2L, "Peter", 43)),
                receiver.getPersons());
    }

    @Test
    @DisplayName("Should throw on update of an unknown Id")
    void testUpdateOfUnknownIdFails() {
        invoker.addCommand(new UpdatePersonCommand(receiver, new Person(1L, "Paul", 34)));

        assertThrows(NoSuchElementException.class, invoker::runCommands);
    }

    @Test
    @DisplayName("Should throw because Id missing on update")
    void testUpdateWithoutIdFails() {
        invoker.addCommand(new UpdatePersonCommand(receiver, new Person(null, "Paul", 34)));

        assertThrows(IllegalArgumentException.class, invoker::runCommands);
    }

    @Test
    @DisplayName("Should give a new unique Id after update and delete")
    void testIdsStayUniqueAfterUpdateAndDelete() {
        invoker.addCommand(new CreatePersonCommand(receiver, "John", 62));
        invoker.addCommand(new CreatePersonCommand(receiver, "Peter", 43));
        invoker.addCommand(new UpdatePersonCommand(receiver, new Person(1L, "Paul", 34)));
        invoker.addCommand(new DeletePersonCommand(receiver, 2L));
        invoker.addCommand(new CreatePersonCommand(receiver, "James", 21));
        invoker.runCommands();

        assertEquals(
                List.of(new Person(1L, "Paul", 34), new Person(3L, "James", 21)),
                receiver.getPersons());
    }

    @Test
    @DisplayName("Should delete a 'Person' element")
    void testDeleteElement() {
        invoker.addCommand(new CreatePersonCommand(receiver, "Peter", 62));
        invoker.addCommand(new DeletePersonCommand(receiver, 1L));
        invoker.runCommands();

        assertTrue(receiver.getPersons().isEmpty());
    }

    @Test
    @DisplayName("Should throw on delete of an unknown Id")
    void testDeleteOfUnknownIdFails() {
        invoker.addCommand(new DeletePersonCommand(receiver, 1L));

        assertThrows(NoSuchElementException.class, invoker::runCommands);
    }

    @Test
    @DisplayName("Should run each command only once")
    void testCommandsRunOnlyOnce() {
        invoker.addCommand(new CreatePersonCommand(receiver, "John", 62));
        invoker.runCommands();
        invoker.runCommands();

        assertEquals(List.of(new Person(1L, "John", 62)), receiver.getPersons());
    }
}
