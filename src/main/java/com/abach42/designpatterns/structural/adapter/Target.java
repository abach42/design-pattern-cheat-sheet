package com.abach42.designpatterns.structural.adapter;

public interface Target<T> {
    T fetchData();

    record Record(Integer id, String name) {}
}