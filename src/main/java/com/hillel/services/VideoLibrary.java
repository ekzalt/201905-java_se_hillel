package com.hillel.services;

import com.hillel.dao.Database;
import com.hillel.dao.DatabaseInterface;
import com.hillel.entity.Actor;
import com.hillel.entity.Director;
import com.hillel.entity.Film;

import java.util.List;

public class VideoLibrary implements DatabaseInterface {
    private DatabaseInterface db = new Database();

    public void run() {
        System.out.println(db.findFilmsBetweenYears(2008, 2018));
        System.out.println(db.findActorsByFilmName("Captain America"));
        System.out.println(db.findActorsWhoHasFilmsCount(2));
        System.out.println(db.findDirectorByName("test"));
        // System.out.println(db.deleteFilmsOlderThan(2000));
    }

    @Override
    public int findFilmIdByName(String name) {
        return 0;
    }

    @Override
    public List<Film> findFilmsBetweenYears(int from, int to) {
        return db.findFilmsBetweenYears(from, to);
    }

    @Override
    public int deleteFilmsOlderThan(int year) {
        return db.deleteFilmsOlderThan(year);
    }

    @Override
    public List<Actor> findActorsByFilmId(int id) {
        return null;
    }

    @Override
    public List<Actor> findActorsByFilmName(String name) {
        return db.findActorsByFilmName(name);
    }

    @Override
    public List<Actor> findActorsWhoHasFilmsCount(int count) {
        return db.findActorsWhoHasFilmsCount(count);
    }

    @Override
    public Director findDirectorByName(String name) {
        return db.findDirectorByName(name);
    }
}
