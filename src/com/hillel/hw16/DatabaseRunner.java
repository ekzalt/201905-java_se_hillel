package com.hillel.hw16;

import com.hillel.hw16.dao.Database;

public class DatabaseRunner {
    private Database db;

    public DatabaseRunner(Database db) {
        this.db = db;
    }

    public void run() {
        System.out.println(db.findAllFilms());
    }
}
