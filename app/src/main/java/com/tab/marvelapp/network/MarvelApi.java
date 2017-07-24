package com.tab.marvelapp.network;

import com.tab.marvelapp.model.ComicsResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

public interface MarvelApi {

    @GET("/v1/public/comics")
    Observable<ComicsResponse> fetchComics(@Query("limit")  int limit);
}
