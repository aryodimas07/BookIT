package com.filkom.aryodimas.bookit.model;

public class OrderHistoryModel {
    private String orderId;
    private String totalPrice;
    private String cinemaLocation;
    private String movieChoice;

    public OrderHistoryModel() {
    }

    public OrderHistoryModel(String orderId, String totalPrice, String cinemaLocation,String movieChoice) {
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.cinemaLocation = cinemaLocation;
        this.movieChoice = movieChoice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCinemaLocation() {
        return cinemaLocation;
    }

    public void setCinemaLocation(String cinemaLocation) {
        this.cinemaLocation = cinemaLocation;
    }

    public String getMovieChoice() {
        return movieChoice;
    }

    public void setMovieChoice(String movieChoice) {
        this.movieChoice = movieChoice;
    }
}
