package com.tab.marvelapp.ui.activities.comicsList;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import com.tab.marvelapp.R;
import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.ui.activities.comicDetail.ComicDetailActivity;
import com.tab.marvelapp.ui.recycleviewItem.ComicItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;

public class ComicsListActivity extends AppCompatActivity implements ComicItem.OnClickListener, SearchView.OnQueryTextListener {

    @BindView(R.id.comicList)
    RecyclerView comicList;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private FlexibleAdapter<ComicItem> adapter;

    public static Intent createInstance(Context context, Result[] results) {
        Intent intent = new Intent(context, ComicsListActivity.class);
        intent.putExtra("results", results);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_list);
        ButterKnife.bind(this);
        setupLayout();

        Intent intent = getIntent();
        setupComics((Result[]) intent.getSerializableExtra("results"));
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

    public void setupComics(Result[] results) {
        System.out.println();

        List<ComicItem> items = new ArrayList<>();

        for (Result result : results) {
            items.add(new ComicItem(result, this));
        }

        this.adapter.updateDataSet(items);
    }

    @Override
    public void onComicSelected(Result result) {
        System.out.println();
        Intent intent = ComicDetailActivity.createInstance(this, result);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_out_left, R.anim.slide_in_right);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
