package com.abach42.designpatterns.behavioral.command;

public class CreatePersonCommand implements Command {
    private PersonSetReceiver receiver;
    private Person person;

    public CreatePersonCommand(PersonSetReceiver receiver, Person person) {
        this.receiver = receiver;
        this.person = person;
    }

    @Override
    public void execute() {
        Person newPerson = new Person(receiver.getNextId(), person.getName(), person.getAge());
        receiver.addPerson(newPerson);
    }
}