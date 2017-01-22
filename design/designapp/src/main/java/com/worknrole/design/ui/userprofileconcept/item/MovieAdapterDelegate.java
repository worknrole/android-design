package com.worknrole.design.ui.userprofileconcept.item;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapterDelegate;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 21/01/17.
 *
 * The custom adapter delegate managing and matching {@link MovieItem}
 * to {@link com.worknrole.design.ui.userprofileconcept.view.MovieItemView}
 */

public class MovieAdapterDelegate extends WNRAdapterDelegate<MovieItem> {

    public MovieAdapterDelegate(int viewType) {
        super(viewType);
    }

    @Override
    public boolean isForItem(MovieItem item) {
        return item instanceof MovieItem;
    }

    @Override
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WNRViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.upc_item_view_movie, parent, false));
    }
}
