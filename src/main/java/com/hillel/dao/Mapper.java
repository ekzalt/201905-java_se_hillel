package com.hillel.dao;

import com.hillel.entity.Actor;
import com.hillel.entity.Director;
import com.hillel.entity.Film;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Mapper implements MapperInterface {
    private DatabaseInterface db;

    public Mapper(DatabaseInterface db) {
        this.db = db;
    }

    @Override
    public Film mapToFilm(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        int id = 0;
        String name = "";
        List<Actor> actors = new ArrayList<>();
        Director director = null;
        String country = "";
        Date released = null;

        try {
            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            country = resultSet.getString(3);
            released = resultSet.getDate(4);

            int directorId = resultSet.getInt(8);
            String directorName = resultSet.getString(9);
            Date directorBorn = resultSet.getDate(10);
            director = new Director(directorId, directorName, directorBorn);

            actors = db.findActorsByFilmId(id); // TODO: optimize it, create cache map for actors list
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Film(id, name, actors, director, country, released);
    }

    @Override
    public Actor mapToActor(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        int id = 0;
        String name = "";
        Date born = null;

        try {
            id = resultSet.getInt(4);
            name = resultSet.getString(5);
            born = resultSet.getDate(6);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Actor(id, name, born);
    }
}
