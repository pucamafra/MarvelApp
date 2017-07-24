package com.tab.marvelapp;

import android.app.Application;

import com.tab.marvelapp.di.AppComponent;
import com.tab.marvelapp.di.DaggerAppComponent;
import com.tab.marvelapp.di.DataModule;
import com.tab.marvelapp.di.NetworkModule;


public class MarvelApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        appComponent = DaggerAppComponent.builder()
                .dataModule(new DataModule(getApplicationContext()))
                .networkModule(new NetworkModule(getBaseURL(), getPublicKey(), getPrivateKey()))
                .build();
    }

    public static AppComponent getApiComponent() {
        return appComponent;
    }

    private String getBaseURL() {
        return getString(R.string.api_base_url);
    }

    private String getPublicKey() {
        return getString(R.string.public_key);
    }

    private String getPrivateKey() {
        return getString(R.string.private_key);
    }
}
