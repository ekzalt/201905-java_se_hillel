package com.hillel.dao;

import com.hillel.entity.Actor;
import com.hillel.entity.Film;

import java.sql.ResultSet;

public interface MapperInterface {
    Film mapToFilm(ResultSet resultSet);

    Actor mapToActor(ResultSet resultSet);
}
