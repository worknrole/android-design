package com.worknrole.design.home;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapterDelegate;
import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 10/03/17.
 */

public class HomeItemAdapterDelegate extends WNRAdapterDelegate {

    private static final int HOME_ITEM = 0;

    public HomeItemAdapterDelegate() {
        super(HOME_ITEM);
    }

    @Override
    public boolean isForItem(WNRItem item) {
        return item instanceof HomeItem;
    }

    @Override
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WNRViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.home_item, parent, false));
    }
}
