package com.hillel.hw16;

import com.hillel.hw16.dao.Database;
import com.hillel.hw16.dao.DatabaseInterface;

public class VideoLibrary {
    private DatabaseInterface db = new Database();

    public void run() {
        System.out.println(db.findFilmsBetweenYears(2008, 2018));
        // System.out.println(db.findActorsByFilmName("Captain America"));
        // System.out.println(db.findActorsWhoHasFilmsCount(2));
        // System.out.println(db.findDirectorByName("test"));
        // System.out.println(db.deleteFilmsOlderThan(2000));
    }
}
