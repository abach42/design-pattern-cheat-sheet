package com.abach42.designpatterns.structural.composite;

// Leaf Class
public class File implements FileSystemComponent {

    private final String name;
    private final int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String showDetails() {
        return " File: " + name + " (Size: " + size + " KB)";
    }
}
