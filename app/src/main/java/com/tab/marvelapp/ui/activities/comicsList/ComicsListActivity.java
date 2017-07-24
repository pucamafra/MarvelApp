package com.tab.marvelapp.ui.activities.comicsList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tab.marvelapp.MarvelApplication;
import com.tab.marvelapp.R;
import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.ui.activities.comicDetail.ComicDetailActivity;
import com.tab.marvelapp.ui.recycleviewItem.ComicItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;

public class ComicsListActivity extends AppCompatActivity implements ComicsListPresenterView, ComicItem.OnClickListener {

    @Inject
    ComicsListPresenter comicsListPresenter;

    @BindView(R.id.comicList)
    RecyclerView comicList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private FlexibleAdapter<ComicItem> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        ButterKnife.bind(this);
        MarvelApplication.getApiComponent().inject(this);
        setupLayout();
        this.comicsListPresenter.attachView(this);
        this.comicsListPresenter.fetchComics();
    }

    public void setupLayout() {
        setSupportActionBar(this.toolbar);
        this.adapter = new FlexibleAdapter<>(new ArrayList<ComicItem>());
        this.comicList.setAdapter(this.adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.comicList.setLayoutManager(linearLayoutManager);
        this.comicList.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                linearLayoutManager.getOrientation());
        this.comicList.addItemDecoration(dividerItemDecoration);

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
        System.out.println();

        List<ComicItem> items = new ArrayList<>();

        for (Result result : results) {
            items.add(new ComicItem(result, this));
        }

        this.adapter.updateDataSet(items);
    }

    @Override
    public void onComicsFail() {
        Toast.makeText(this, R.string.internal_error, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onComicSelected(Result result) {
        System.out.println();
        Intent intent = ComicDetailActivity.createInstance(this, result);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.comicsListPresenter.detachView();
    }
}
