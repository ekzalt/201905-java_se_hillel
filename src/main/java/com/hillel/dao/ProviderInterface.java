package com.hillel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface ProviderInterface {
    Connection getConnection() throws ClassNotFoundException, SQLException;

    void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection);
}
