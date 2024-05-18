package com.abach42.designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {
    private final List<Colleague> colleagues;

    public Mediator() {
        this.colleagues = new ArrayList<>();
    }

    public void addColleague(Colleague colleague) {
        this.colleagues.add(colleague);
    }
    
    public void sendMessage(String message, Colleague colleague) {
        for (Colleague col : colleagues) {
            if (col != colleague) {
                col.receive(message);
            }
        }
    }
}
