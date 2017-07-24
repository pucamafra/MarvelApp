package com.tab.marvelapp.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.tab.marvelapp.config.Constants;
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
    private String mPublicKey;
    private String mPrivateKey;

    public NetworkModule(String baseURL, String publicKey, String privateKey) {
        this.mBaseURL = baseURL;
        this.mPublicKey = publicKey;
        this.mPrivateKey = privateKey;
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
    MarvelDataSource provideMarvelDataSource(MarvelRemoteData marvelRemoteData) {
        return new MarvelRepository(marvelRemoteData);
    }

    @Provides
    @Singleton
    MarvelApi provideMarvelApi(RestAdapter.Builder restAdapterBuilder) {
        restAdapterBuilder.setRequestInterceptor(request -> {

            long ts = (System.currentTimeMillis() / 1000);
            String hash = HashGenerator.generate(ts, this.mPrivateKey, this.mPublicKey);

            request.addQueryParam(Constants.API_KEY, mPublicKey);
            request.addQueryParam(Constants.HASH, hash);
            request.addQueryParam(Constants.TS, Long.toString(ts));

        });
        return restAdapterBuilder.build().create(MarvelApi.class);
    }


}
