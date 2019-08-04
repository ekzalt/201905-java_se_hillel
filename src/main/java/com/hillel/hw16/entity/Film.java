package com.hillel.hw16.entity;

import java.sql.Date;
import java.util.List;

public class Film extends Entity {
    private List<Actor> actors;
    private Director director;
    private String country;
    private Date released;

    public Film(int id, String name, List<Actor> actors, Director director, String country, Date released) {
        super(id, name);

        this.actors = actors;
        this.director = director;
        this.country = country;
        this.released = released;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getReleased() {
        return released;
    }

    public void setReleased(Date released) {
        this.released = released;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + getName() + '\'' +
                ", actors=" + getActors() +
                ", director='" + getDirector() + '\'' +
                ", country='" + getCountry() + '\'' +
                ", released='" + getReleased() + '\'' +
                '}';
    }
}
