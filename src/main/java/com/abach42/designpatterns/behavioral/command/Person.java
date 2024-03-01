package com.abach42.designpatterns.behavioral.command;

public class Person {
    private Long id; 
    private String name; 
    private Integer age;

    public Person(Long id, String name, Integer age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person(String name, Integer age){
        this.id = null;
        this.name = name;
        this.age = age;
    }

    public Person(Long id){
        this.id = id;
        this.name = null;
        this.age = null;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object comparison) {
        if(comparison == null || false == comparison instanceof Person) {
            return false;
        }
        
        Person person = (Person) comparison;
        return this.id == person.id 
            && this.name == person.name
            && this.age == person.age;
    }
}