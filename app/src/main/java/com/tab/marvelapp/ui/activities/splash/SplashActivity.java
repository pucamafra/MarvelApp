package com.tab.marvelapp.ui.activities.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tab.marvelapp.MarvelApplication;
import com.tab.marvelapp.R;
import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.ui.activities.comicsList.ComicsListActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity implements SplashPresenterView, View.OnClickListener {

    @Inject
    SplashPresenter splashPresenter;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.parent_container)
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        MarvelApplication.getApiComponent().inject(this);
        this.splashPresenter.attachView(this);
        this.splashPresenter.fetchComics();
    }

    @Override
    public void showLoading() {
        this.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void dismissLoading() {
        this.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onComicsSuccess(Result[] results) {
        Intent intent = ComicsListActivity.createInstance(this, results);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

    @Override
    public void onComicsFail() {
        showSnackBarWithAction(this.view);
    }

    private void showSnackBarWithAction(View view) {
        Snackbar.make(view, R.string.internal_error, Snackbar.LENGTH_INDEFINITE)
                .setAction(R.string.try_again, this)
                .show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.splashPresenter.detachView();
    }

    @Override
    public void onClick(View v) {
        this.splashPresenter.fetchComics();
    }
}
