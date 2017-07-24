package com.tab.marvelapp.data;


import com.tab.marvelapp.model.ComicsResponse;

import rx.Observable;

public interface MarvelDataSource {

    Observable<ComicsResponse> fetchComics();

}
