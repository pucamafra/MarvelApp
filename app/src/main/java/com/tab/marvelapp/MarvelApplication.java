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
                .networkModule(new NetworkModule(getString(R.string.api_base_url)))
                .build();
    }

    public static AppComponent getApiComponent() {
        return appComponent;
    }
}
