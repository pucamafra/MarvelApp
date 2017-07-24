package com.tab.marvelapp.model;


import java.io.Serializable;

public class Item implements Serializable {
    private String resourceURI;
    private String name;

    public String getName() {
        return name;
    }
}
