package com.abach42.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Composite Class
public class Folder implements FileSystemComponent {

    private final String name;
    private final List<FileSystemComponent> components = new ArrayList<>();

    public Folder(String name) {
        this.name = name;
    }

    public void addComponent(FileSystemComponent component) {
        components.add(component);
    }

    public void removeComponent(FileSystemComponent component) {
        components.remove(component);
    }

    @Override
    public String showDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Folder: ").append(name).append("\n");
        for (FileSystemComponent component : components) {
            details.append("  ").append(component.showDetails()).append("\n");
        }
        return details.toString();
    }
}