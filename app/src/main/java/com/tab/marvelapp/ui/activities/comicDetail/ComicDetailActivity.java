package com.tab.marvelapp.ui.activities.comicDetail;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.squareup.picasso.Picasso;
import com.tab.marvelapp.R;
import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.model.Thumbnail;
import com.tab.marvelapp.utils.FormatUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.image)
    AppCompatImageView image;

    @BindView(R.id.title)
    AppCompatTextView title;

    @BindView(R.id.description)
    AppCompatTextView description;

    @BindView(R.id.page_count)
    AppCompatTextView pageCount;

    @BindView(R.id.authors)
    AppCompatTextView authors;

    public static Intent createInstace(Context context, Result result) {
        Intent intent = new Intent(context, ComicDetailActivity.class);
        intent.putExtra("result", result);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comics_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        setupLayout((Result) intent.getSerializableExtra("result"));
    }

    private void setupLayout(Result result) {
        setSupportActionBar(this.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        int pageCount = result.getPageCount();

        this.title.setText(result.getTitle());
        this.description.setText(result.getDescription());
        this.pageCount.setText(getResources().getQuantityString(R.plurals.page_count, pageCount, pageCount));

        this.authors.setText(FormatUtils.formatAuthors(result));

        if (result.getThumbnail() != null) {
            Thumbnail thumbnail = result.getThumbnail();
            Picasso.with(this)
                    .load(thumbnail.getUrl())
                    .centerInside()
                    .fit()
                    .into(this.image);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
