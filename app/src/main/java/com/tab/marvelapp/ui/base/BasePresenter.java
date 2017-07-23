package com.tab.marvelapp.ui.base;


import rx.subscriptions.CompositeSubscription;

public class BasePresenter<T extends IPresenterView> implements IPresenter<T> {

    private T view;

    protected CompositeSubscription compositeSubscription;

    @Override
    public void attachView(T view) {
        this.view = view;
        this.compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        this.view = null;
        if (!this.compositeSubscription.isUnsubscribed()) {
            this.compositeSubscription.unsubscribe();
        }
        this.compositeSubscription.clear();
        this.compositeSubscription = null;
    }

    public T getView() {
        return this.view;
    }

    public boolean isViewAttached() {
        return this.view != null;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) {
            throw new PresenterViewNotAttachedException("Please call Presenter.attachView(IPresenterView view) before use it");
        }
    }

    private static class PresenterViewNotAttachedException extends RuntimeException {
        PresenterViewNotAttachedException(String message) {
            super(message);
        }
    }
}
