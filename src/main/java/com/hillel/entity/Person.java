package com.hillel.entity;

import java.sql.Date;

public abstract class Person extends Entity {
    private Date born;

    public Person(int id, String name, Date born) {
        super(id, name);

        this.born = born;
    }

    public Date getBorn() {
        return born;
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    @Override
    public String toString() {
        return "" + getClass().getSimpleName() + "{" +
                "id='" + getId() + '\'' +
                "name='" + getName() + '\'' +
                "born=" + getBorn() +
                '}';
    }
}
