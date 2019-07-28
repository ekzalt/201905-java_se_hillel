package com.hillel.hw16.entity;

public class Person extends Base {
    private String name;

    public Person(int id, String name) {
        super(id);

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
