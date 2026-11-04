package com.abach42.designpatterns.behavioral.command;

import java.util.ArrayDeque;
import java.util.Queue;

public class PersonInvoker {

    private final Queue<Command> commands = new ArrayDeque<>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void runCommands() {
        while (!commands.isEmpty()) {
            commands.poll().execute();
        }
    }

    //todo implement undo of command
    //todo log errors
}
