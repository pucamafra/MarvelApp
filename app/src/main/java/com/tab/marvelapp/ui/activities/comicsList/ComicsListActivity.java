package com.tab.marvelapp.ui.activities.comicsList;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.tab.marvelapp.MarvelApplication;
import com.tab.marvelapp.R;
import com.tab.marvelapp.model.Result;
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
        this.adapter = new FlexibleAdapter<>(new ArrayList<ComicItem>());
        this.comicList.setAdapter(this.adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setAutoMeasureEnabled(true);
        this.comicList.setLayoutManager(linearLayoutManager);
        this.comicList.setNestedScrollingEnabled(false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                linearLayoutManager.getOrientation());
        comicList.addItemDecoration(dividerItemDecoration);

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
        System.out.println();
    }

    @Override
    public void onClick(Result result) {
        System.out.println();
    }
}
