package com.hillel.services;

import com.hillel.dao.Database;
import com.hillel.dao.DatabaseInterface;
import com.hillel.entity.User;

public class UserService {
    private DatabaseInterface db = new Database();

    public User findUser(String name, String password) {
        return db.findUser(name, password);
    }
}
