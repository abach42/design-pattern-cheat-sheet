package com.abach42.designpatterns.behavioral.command;

public class DeletePersonCommand implements Command {

    private final PersonReceiver receiver;
    private final long id;

    public DeletePersonCommand(PersonReceiver receiver, long id) {
        this.receiver = receiver;
        this.id = id;
    }

    @Override
    public void execute() {
        receiver.deletePerson(id);
    }
}
