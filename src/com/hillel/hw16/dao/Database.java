package com.hillel.hw16.dao;

import com.hillel.hw16.entity.Film;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Database {
    private final String DB_HOST = "localhost";
    private final String DB_PORT = "3306";
    private final String DB_NAME = "local";
    private final String DB_USER = "root";
    private final String DB_PASS = "root";

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, DB_USER, DB_PASS);
    }

    public List<Film> findAllFilms() {
        String query = "SELECT * FROM `films`";
        List<Film> films = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                films.add(mapToFilm(resultSet));
            }
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        close(resultSet,preparedStatement, connection);
        return films;
    }

    private Film mapToFilm(ResultSet resultSet) {
        if (resultSet == null) {
            throw new UnsupportedOperationException("ResultSet is required");
        }

        int id = 0;
        String name = "";
        List<String> actors = new ArrayList<>();
        String director = "";
        String country = "";

        try {
            id = resultSet.getInt(1);
            name = resultSet.getString(2);
            actors = Arrays.asList(resultSet.getString(3).split(","));
            director = resultSet.getString(4);
            country = resultSet.getString(5);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new Film(id, name, actors, director, country);
    }

    private void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
        closeResultSet(resultSet);
        closePreparedStatement(preparedStatement);
        closeConnection(connection);
    }

    private void closeResultSet(ResultSet resultSet) {
        if (resultSet == null) {
            return;
        }

        try {
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closePreparedStatement(PreparedStatement preparedStatement) {
        if (preparedStatement == null) {
            return;
        }

        try {
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeConnection(Connection connection) {
        if (connection == null) {
            return;
        }

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
