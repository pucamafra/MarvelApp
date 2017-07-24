package com.tab.marvelapp.model;


import java.io.Serializable;

public class Result implements Serializable {
    private String id;
    private String title;
    private String description;
    private Thumbnail thumbnail;
    private Price[] prices;
    private int pageCount;

    private Creators creators;

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


    public int getPageCount() {
        return pageCount;
    }

    public Creators getCreators() {
        return creators;
    }
}
