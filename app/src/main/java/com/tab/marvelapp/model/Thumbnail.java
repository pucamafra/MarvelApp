package com.tab.marvelapp.model;


import java.io.Serializable;

public class Thumbnail implements Serializable {

    private String path;

    private String extension;

    public String getExtension() {
        return extension;
    }

    public String getPath() {
        return path;
    }

    public String getUrl(){
        return path + "." + extension;
    }
}
