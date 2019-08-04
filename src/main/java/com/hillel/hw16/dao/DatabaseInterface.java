package com.hillel.hw16.dao;

import com.hillel.hw16.entity.Actor;
import com.hillel.hw16.entity.Director;
import com.hillel.hw16.entity.Film;

import java.util.List;

public interface DatabaseInterface {
    int findFilmIdByName(String name);

    List<Film> findFilmsBetweenYears(int from, int to);

    int deleteFilmsOlderThan(int year);

    List<Actor> findActorsByFilmId(int id);

    List<Actor> findActorsByFilmName(String name);

    List<Actor> findActorsWhoHasFilmsCount(int count);

    Director findDirectorByName(String name);
}
