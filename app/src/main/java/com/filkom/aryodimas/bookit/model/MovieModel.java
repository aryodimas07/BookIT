package com.filkom.aryodimas.bookit.model;

public class MovieModel {
    private String title, desc, datePlay,moviePicUrl;
    private int rating;

    public MovieModel(String title, String desc, int rating, String datePlay, String movPicId) {
        this.title = title;
        this.desc = desc;
        this.rating = rating;
        this.datePlay = datePlay;
        this.moviePicUrl = movPicId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDatePlay() {
        return datePlay;
    }

    public void setDatePlay(String datePlay) {
        this.datePlay = datePlay;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getMoviePicUrl() {
        return moviePicUrl;
    }

    public void setMoviePicUrl(String moviePicUrl) {
        this.moviePicUrl = moviePicUrl;
    }
}
