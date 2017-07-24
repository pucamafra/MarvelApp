package com.tab.marvelapp.ui.activities.comicsList;


import com.tab.marvelapp.data.MarvelDataSource;
import com.tab.marvelapp.model.ComicsResponse;
import com.tab.marvelapp.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ComicsListPresenter extends BasePresenter<ComicsListPresenterView> {

    private MarvelDataSource marvelDataSource;

    @Inject
    ComicsListPresenter(MarvelDataSource marvelDataSource) {
        this.marvelDataSource = marvelDataSource;
    }

    void fetchComics() {
        checkViewAttached();
        final ComicsListPresenterView view = getView();

        this.marvelDataSource.fetchComics()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ComicsResponse>() {
                    @Override
                    public void onCompleted() {
                        System.out.println();
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println();
                        view.onComicsFail();
                    }

                    @Override
                    public void onNext(ComicsResponse comicsResponse) {
                        System.out.println();
                        view.onComicsSuccess(comicsResponse.getData().getResults());
                    }
                });

    }
}
