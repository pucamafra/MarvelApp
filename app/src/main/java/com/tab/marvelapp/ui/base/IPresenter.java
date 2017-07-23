package com.tab.marvelapp.ui.base;


public interface IPresenter<T extends IPresenterView> {

    void attachView(T view);

    void detachView();

}
