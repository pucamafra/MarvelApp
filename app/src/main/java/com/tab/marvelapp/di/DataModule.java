package com.tab.marvelapp.di;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.tab.marvelapp.config.AppKey;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    private Context mContext;

    public DataModule(Context context) {
        this.mContext = context;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreference() {
        return this.mContext.getSharedPreferences(AppKey.SharedKeys.PREF_KEY_STORAGE, Activity.MODE_PRIVATE);
    }


}
