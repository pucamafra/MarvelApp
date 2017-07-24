package com.tab.marvelapp.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Price implements Serializable {

    private String type;

    @SerializedName("price")
    private float value;

}
