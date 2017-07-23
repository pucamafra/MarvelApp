package com.tab.marvelapp.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.tab.marvelapp.data.MarvelDataSource;
import com.tab.marvelapp.data.MarvelRepository;
import com.tab.marvelapp.data.remote.MarvelRemoteData;
import com.tab.marvelapp.network.MarvelApi;
import com.tab.marvelapp.utils.HashGenerator;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.android.AndroidLog;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

@Module
public class NetworkModule {

    private final int TIME_OUT = 10;
    private final TimeUnit timeUnit = TimeUnit.SECONDS;
    private String mBaseURL;

    public NetworkModule(String baseURL) {
        this.mBaseURL = baseURL;
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(TIME_OUT, timeUnit);
        okHttpClient.setConnectTimeout(TIME_OUT, timeUnit);
        okHttpClient.setWriteTimeout(TIME_OUT, timeUnit);
        return okHttpClient;
    }

    @Provides
    @Singleton
    RestAdapter.Builder provideRestAdapter(Gson gson, OkHttpClient okHttpClient) {
        return new RestAdapter.Builder()
                .setEndpoint(this.mBaseURL)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setLog(new AndroidLog("server:message"))
                .setClient(new OkClient(okHttpClient));
    }

    @Provides
    @Singleton
    MarvelDataSource provideMarvelRespository(MarvelRemoteData marvelRemoteData) {
        return new MarvelRepository(marvelRemoteData);
    }

    @Provides
    @Singleton
    MarvelApi provideMarvelApi(RestAdapter.Builder restAdapterBuilder) {
        restAdapterBuilder.setRequestInterceptor(new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {

                long ts = (System.currentTimeMillis() / 1000);
                String publicKey = "c9a0ab6a03e62fe32e7bbede9aea94bf";
                String privateKey = "a35abd89f31d879b43d3762bbb222b24ca532d13";

                String hash = HashGenerator.generate(ts, privateKey, publicKey);

                request.addQueryParam("apikey", publicKey);
                request.addQueryParam("hash", hash);
                request.addQueryParam("ts", Long.toString(ts));

            }
        });
        return restAdapterBuilder.build().create(MarvelApi.class);
    }


}
