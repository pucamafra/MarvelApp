package com.tab.marvelapp.model;


import java.io.Serializable;

public class Data implements Serializable {

    private int total;

    private int limit;

    private Result[] results;

    private int count;

    private int offset;

    public int getCount() {
        return count;
    }

    public int getLimit() {
        return limit;
    }

    public int getOffset() {
        return offset;
    }

    public int getTotal() {
        return total;
    }

    public Result[] getResults() {
        return results;
    }

}
