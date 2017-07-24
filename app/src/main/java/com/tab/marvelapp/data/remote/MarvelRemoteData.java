package com.tab.marvelapp.data.remote;


import com.tab.marvelapp.model.ComicsResponse;
import com.tab.marvelapp.network.MarvelApi;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;

@Singleton
public class MarvelRemoteData {

    private final int LIMIT = 100;

    private final MarvelApi marvelApi;

    @Inject
    public MarvelRemoteData(MarvelApi marvelApi) {
        this.marvelApi = marvelApi;
    }

    public Observable<ComicsResponse> fetchComics() {
        return this.marvelApi.fetchComics(LIMIT);
    }


}
