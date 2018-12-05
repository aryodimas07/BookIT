package com.filkom.aryodimas.bookit;

public class Movie {
    String title, desc, datePlay;
    int rating, movPicId;

    public Movie(String title, String desc, int rating, String datePlay, int movPicId) {
        this.title = title;
        this.desc = desc;
        this.rating = rating;
        this.datePlay = datePlay;
        this.movPicId = movPicId;
    }
}
