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
        void onComicSelected(Result result);
    }

    private final Result result;
    private final OnClickListener listener;

    public ComicItem(Result result, OnClickListener listener) {
        this.result = result;
        this.listener = listener;
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
            Picasso.with(viewHolder.getContentView().getContext())
                    .load(thumbnail.getUrl())
                    .fit()
                    .centerInside()
                    .into(viewHolder.thumbnail);
        }

        viewHolder.view.setOnClickListener(v -> listener.onComicSelected(result));

    }

    protected static class ViewHolder extends FlexibleViewHolder {
        @BindView(R.id.title)
        AppCompatTextView title;

        @BindView(R.id.thumbnail)
        AppCompatImageView thumbnail;

        View view;

        ViewHolder(View view, final FlexibleAdapter adapter) {
            super(view, adapter);
            ButterKnife.bind(this, view);
            this.view = view;
        }
    }


}
