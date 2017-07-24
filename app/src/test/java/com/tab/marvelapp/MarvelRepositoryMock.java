package com.tab.marvelapp;


import com.tab.marvelapp.data.MarvelDataSource;
import com.tab.marvelapp.model.ComicsResponse;

import rx.Observable;

public class MarvelRepositoryMock implements MarvelDataSource {

    public MarvelRepositoryMock() {
    }

    @Override
    public Observable<ComicsResponse> fetchComics() {
        return Observable.just(MockUtils.getMock());
    }


}
