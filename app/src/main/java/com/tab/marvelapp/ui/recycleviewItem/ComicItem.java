package com.tab.marvelapp.ui.recycleviewItem;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;
import com.tab.marvelapp.R;
import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.model.Thumbnail;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.davidea.flexibleadapter.FlexibleAdapter;
import eu.davidea.flexibleadapter.items.AbstractFlexibleItem;
import eu.davidea.viewholders.FlexibleViewHolder;

public class ComicItem extends AbstractFlexibleItem<ComicItem.ViewHolder> {


    public interface OnClickListener {
         void onClick(Result result);
    }

    private final Result result;
    private final OnClickListener listner;

    public ComicItem(Result result,OnClickListener listner) {
        this.result = result;
        this.listner = listner;
    }

    @Override
    public boolean equals(Object inObject) {
        if (inObject instanceof ComicItem) {
            ComicItem inItem = (ComicItem) inObject;
            return this.result.getId().equals(inItem.result.getId());
        }
        return false;
    }

    @Override
    public int getLayoutRes() {
        return R.layout.comic_item;
    }

    @Override
    public ViewHolder createViewHolder(FlexibleAdapter adapter, LayoutInflater inflater, ViewGroup parent) {
        return new ViewHolder(inflater.inflate(getLayoutRes(), parent, false), adapter);
    }

    @Override
    public void bindViewHolder(final FlexibleAdapter adapter, ViewHolder viewHolder, int position, List payloads) {
        viewHolder.title.setText(result.getTitle());

        if (this.result.getThumbnail() != null) {
            Thumbnail thumbnail = this.result.getThumbnail();
            String url = thumbnail.getPath() + "." + thumbnail.getExtension();
            Picasso.with(viewHolder.getContentView().getContext())
                    .load(url)
                    .fit()
                    .centerInside()
                    .into(viewHolder.thumbnail);
        }

        viewHolder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listner.onClick(result);
            }
        });



       /* final Picasso imageLoader = Picasso.with(context);
        imageLoader.load(photoEntity.mediaUrl)
                .fit()
                .placeholder(new ColorDrawable(Color.GRAY))
                .error(com.twitter.sdk.android.tweetui.R.drawable.tw__ic_tweet_photo_error_light)
                .into(imageView, new PicassoCallback(imageView));*/

    }

    protected static class ViewHolder extends FlexibleViewHolder {
        @BindView(R.id.title)
        AppCompatTextView title;

        @BindView(R.id.thumbnail)
        AppCompatImageView thumbnail;

        View view;

        public ViewHolder(View view, final FlexibleAdapter adapter) {
            super(view, adapter);
            ButterKnife.bind(this, view);
            this.view = view;
        }
    }


}
