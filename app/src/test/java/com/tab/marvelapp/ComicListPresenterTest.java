package com.tab.marvelapp;

import com.tab.marvelapp.ui.activities.comicsList.ComicsListPresenter;
import com.tab.marvelapp.ui.activities.comicsList.ComicsListPresenterView;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ComicListPresenterTest {

    private ComicsListPresenter comicsListPresenter;

    @Mock
    ComicsListPresenterView view;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });

        this.comicsListPresenter = new ComicsListPresenter(new MarvelRepositoryMock());
        this.comicsListPresenter.attachView(this.view);
    }

    @Test
    public void fetchComicList() throws Exception {
        this.comicsListPresenter.fetchComics();
        verify(this.view).showLoading();
        verify(this.view).onComicsSuccess(MockUtils.getMock().getData().getResults());
        verify(this.view).dismissLoading();
    }


    @After
    public void tearDown() {
        RxAndroidPlugins.getInstance().reset();
    }
}