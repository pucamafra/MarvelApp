package com.tab.marvelapp.model;


import java.io.Serializable;

public class ComicsResponse implements Serializable {

    private int code;

    private String status;

    private String attributionText;

    private String eTag;

    private String copyright;

    private String attributionHTML;

    private Data data;

    public Data getData() {
        return data;
    }
}
