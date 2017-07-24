package com.tab.marvelapp.ui.activities.comicsList;


import com.tab.marvelapp.data.MarvelDataSource;
import com.tab.marvelapp.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ComicsListPresenter extends BasePresenter<ComicsListPresenterView> {

    private MarvelDataSource marvelDataSource;

    @Inject
    public ComicsListPresenter(MarvelDataSource marvelDataSource) {
        this.marvelDataSource = marvelDataSource;
    }

    public void fetchComics() {
        checkViewAttached();
        final ComicsListPresenterView view = getView();
        view.showLoading();
        Subscription subscription = this.marvelDataSource.fetchComics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        comicsResponse -> {
                            view.onComicsSuccess(comicsResponse.getData().getResults());
                            view.dismissLoading();
                        },
                        throwable -> {
                            view.dismissLoading();
                            view.onComicsFail();
                        }
                );

        this.compositeSubscription.add(subscription);
    }
}
