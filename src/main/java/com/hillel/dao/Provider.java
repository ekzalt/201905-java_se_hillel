package com.hillel.dao;

import java.sql.*;

public class Provider implements ProviderInterface {
    private String host = "localhost";
    private String port = "3306";
    private String name = "local";
    private String user = "root";
    private String password = "root";

    public Provider() {
    }

    public Provider(String host, String port, String name, String user, String password) {
        this.host = host;
        this.port = port;
        this.name = name;
        this.user = user;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name +
                "?verifyServerCertificate=false" +
                "&useSSL=false" +
                "&requireSSL=false" +
                "&useLegacyDatetimeCode=false" +
                "&amp" +
                "&serverTimezone=UTC";

        // Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url, user, password);
    }

    @Override
    public void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
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
