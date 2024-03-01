package com.abach42.designpatterns.structural.adapter;

@FunctionalInterface
public interface ApiAdaptee<T> {
    T fetchDataFromApi();
}