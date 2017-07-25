package com.tab.marvelapp.di;


import com.tab.marvelapp.ui.activities.comicsList.ComicsListActivity;
import com.tab.marvelapp.ui.activities.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, DataModule.class})
public interface AppComponent {

    void inject(SplashActivity splashActivity);

    void inject(ComicsListActivity comicsListActivity);

}
