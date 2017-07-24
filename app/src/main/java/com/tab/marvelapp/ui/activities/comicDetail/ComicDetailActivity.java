package com.tab.marvelapp.ui.activities.comicDetail;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;

import com.squareup.picasso.Callback;
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

    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    public static Intent createInstance(Context context, Result result) {
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
        setTranslucentStatusBar(getWindow());
        setupLayout();
        setupComic((Result) intent.getSerializableExtra("result"));
    }

    private void setupComic(Result result) {
        this.collapsingToolbarLayout.setTitle(result.getTitle());
        this.collapsingToolbarLayout.setTitle(result.getTitle());
        int pageCount = result.getPageCount();
        this.description.setText(result.getDescription());
        this.pageCount.setText(getResources().getQuantityString(R.plurals.page_count, pageCount, pageCount));
        this.authors.setText(FormatUtils.formatAuthors(result));
        if (result.getThumbnail() != null) {
            Thumbnail thumbnail = result.getThumbnail();
            Picasso.with(this)
                    .load(thumbnail.getUrl())
                    .centerInside()
                    .fit()
                    .into(this.image, new Callback() {
                        @Override
                        public void onSuccess() {
                            dynamicToolbarColor();
                        }

                        @Override
                        public void onError() {
                        }
                    });
        }
    }

    private void setupLayout() {
        setSupportActionBar(this.toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void dynamicToolbarColor() {
        Bitmap bitmap = ((BitmapDrawable) this.image.getDrawable()).getBitmap();
        Palette.from(bitmap).generate(palette -> {
            int mutedColor = palette.getMutedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
            int mutedDarkColor = palette.getDarkMutedColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
            int vibrantColor = palette.getDominantColor(ContextCompat.getColor(getApplicationContext(), R.color.colorAccent));
            collapsingToolbarLayout.setContentScrimColor(mutedColor);
            collapsingToolbarLayout.setStatusBarScrimColor(mutedDarkColor);


            int[][] states = new int[][] {
                    new int[] { android.R.attr.state_enabled}, // enabled
                    new int[] {-android.R.attr.state_enabled}, // disabled
                    new int[] {-android.R.attr.state_checked}, // unchecked
                    new int[] { android.R.attr.state_pressed}  // pressed
            };

            int[] colors = new int[] {
                    vibrantColor,
                    vibrantColor,
                    vibrantColor,
                    vibrantColor
            };

            ColorStateList myList = new ColorStateList(states, colors);

          //  collapsingToolbarLayout.setExpandedTitleTextColor(myList);
        });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }

    public void setTranslucentStatusBar(Window window) {
        if (window == null) return;
        int sdkInt = Build.VERSION.SDK_INT;

        if (sdkInt >= Build.VERSION_CODES.LOLLIPOP) {
            setTranslucentStatusBarLollipop(window);
            return;
        }

        if (sdkInt >= Build.VERSION_CODES.KITKAT) {
            setTranslucentStatusBarKiKat(window);
        }
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void setTranslucentStatusBarLollipop(Window window) {
        window.setStatusBarColor(ContextCompat.getColor(this, android.R.color.transparent));
    }


    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void setTranslucentStatusBarKiKat(Window window) {
        window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
    }

    @Override
    public void onBackPressed() {
        finish();
        overridePendingTransition(R.anim.slide_out_right, R.anim.slide_in_left);
    }
}
