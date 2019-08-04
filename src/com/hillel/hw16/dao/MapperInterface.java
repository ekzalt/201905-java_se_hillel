package com.hillel.hw16.dao;

import com.hillel.hw16.entity.Actor;
import com.hillel.hw16.entity.Film;

import java.sql.ResultSet;

public interface MapperInterface {
    Film mapToFilm(ResultSet resultSet);

    Actor mapToActor(ResultSet resultSet);
}
