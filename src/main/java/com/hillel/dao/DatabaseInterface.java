package com.hillel.dao;

import com.hillel.entity.Actor;
import com.hillel.entity.Director;
import com.hillel.entity.Film;

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
