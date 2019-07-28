package com.hillel.hw16.entity;

import java.util.List;

public class Film extends Base {
    private String name;
    private List<String> actors;
    private String director;
    private String country;

    public Film(int id, String name, List<String> actors,String director, String country) {
        super(id);

        this.name = name;
        this.actors = actors;
        this.director = director;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getDirectors() {
        return director;
    }

    public void setDirectors(String directors) {
        this.director = directors;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Film{" +
                "name='" + name + '\'' +
                ", actors=" + actors +
                ", director='" + director + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
