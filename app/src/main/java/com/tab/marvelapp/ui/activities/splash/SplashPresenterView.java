package com.tab.marvelapp.ui.activities.splash;

import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.ui.base.IPresenterView;


public interface SplashPresenterView extends IPresenterView {

     void showLoading();

     void dismissLoading();

     void onComicsSuccess(Result[] results);

     void onComicsFail();

}
