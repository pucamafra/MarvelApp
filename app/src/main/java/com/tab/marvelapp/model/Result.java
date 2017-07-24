package com.tab.marvelapp.model;


public class Result {
    private String id;
    private String title;
    private String description;
    private Thumbnail thumbnail;
    private Price[] prices;

    public Price[] getPrices() {
        return prices;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

}
