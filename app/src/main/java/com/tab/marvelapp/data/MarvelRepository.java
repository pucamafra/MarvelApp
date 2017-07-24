package com.tab.marvelapp.data;


import com.tab.marvelapp.data.remote.MarvelRemoteData;
import com.tab.marvelapp.model.ComicsResponse;

import rx.Observable;

public class MarvelRepository implements MarvelDataSource {

    private MarvelRemoteData marvelRemoteData;

    public MarvelRepository(MarvelRemoteData marvelRemoteData) {
        this.marvelRemoteData = marvelRemoteData;
    }

    @Override
    public Observable<ComicsResponse> fetchComics() {
        return this.marvelRemoteData.fetchComics();
    }
}
