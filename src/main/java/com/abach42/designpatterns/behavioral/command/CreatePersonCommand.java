package com.abach42.designpatterns.behavioral.command;

public class CreatePersonCommand implements Command {

    private final PersonSetReceiver receiver;
    private final Person person;

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