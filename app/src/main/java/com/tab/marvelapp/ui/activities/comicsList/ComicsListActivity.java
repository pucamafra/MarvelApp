package com.tab.marvelapp.ui.activities.comicsList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tab.marvelapp.MarvelApplication;
import com.tab.marvelapp.R;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ComicsListActivity extends AppCompatActivity implements ComicsListPresenterView {

    @Inject
    ComicsListPresenter comicsListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        ButterKnife.bind(this);
        //MarvelApplication.getApiComponent().inject(this);
        //this.comicsListPresenter.attachView(this);
    }
}
