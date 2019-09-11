package com.hillel.dao;

import com.hillel.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class Database implements DatabaseInterface {
    private ProviderInterface provider = new Provider();
    private MapperInterface mapper = new Mapper(this);

    // films

    @Override
    public int findFilmIdByName(String name) {
        int id = 0;
        String query = "SELECT id FROM `local`.films WHERE name LIKE '%" + name + "%' LIMIT 1";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return id;
    }

    @Override
    public List<Film> findFilmsBetweenYears(int from, int to) {
        List<Film> films = new ArrayList<>();
        String query = "SELECT * FROM `local`.films "
                + "INNER JOIN `local`.directors ON `local`.films.director_id = `local`.directors.id "
                + "WHERE released BETWEEN " + "'" + from + "-01-01'" + " AND " + "'" + to + "-12-31'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                films.add(mapper.mapToFilm(resultSet));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return films;
    }

    @Override
    public int deleteFilmsOlderThan(int year) {
        int affected = 0;
        String query = "DELETE FROM `local`.films "
                + "WHERE released < '" + year + "-01-01'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            affected = preparedStatement.executeUpdate();
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return affected;
    }

    // actors

    @Override
    public List<Actor> findActorsByFilmId(int id) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT * FROM `local`.films_actors "
                + "INNER JOIN `local`.actors ON `local`.films_actors.actor_id = `local`.actors.id "
                + "WHERE `local`.films_actors.film_id = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actors.add(mapper.mapToActor(resultSet));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return actors;
    }

    @Override
    public List<Actor> findActorsByFilmName(String name) {
        return findActorsByFilmId(findFilmIdByName(name));
    }

    @Override
    public List<Actor> findActorsWhoHasFilmsCount(int count) {
        List<Actor> actors = new ArrayList<>();
        String query = "SELECT *, COUNT(*) as entries FROM `local`.films_actors "
                + "INNER JOIN `local`.actors ON `local`.films_actors.actor_id = `local`.actors.id "
                + "GROUP BY `local`.films_actors.actor_id "
                + "HAVING entries >= ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, count);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                actors.add(mapper.mapToActor(resultSet));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return actors;
    }

    // directors

    @Override
    public Director findDirectorByName(String name) {
        int directorId = 0;
        String directorName = "";
        Date directorBorn = null;
        String query = "SELECT * FROM `local`.directors "
                + "WHERE `local`.directors.name LIKE '%" + name + "%' LIMIT 1";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                directorId = resultSet.getInt(1);
                directorName = resultSet.getString(2);
                directorBorn = resultSet.getDate(3);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return directorId > 0 ? new Director(directorId, directorName, directorBorn) : null;
    }

    @Override
    public User findUser(String name, String password) {
        User user = null;
        String query = "SELECT * FROM `local`.users "
                + "WHERE `local`.users.name = ? AND `local`.users.password = ?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = provider.getConnection();
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                Role role = Role.valueOf(resultSet.getString(4));
                user = new User(id, name, password, role);
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        provider.close(resultSet,preparedStatement, connection);
        return user;
    }
}
