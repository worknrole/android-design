package com.worknrole.design.ui.qplanningapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.item.CalendarItem;
import com.worknrole.design.ui.qplanningapp.item.UpcomingItem;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapterDelegate;
import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 13/03/17.
 */

public class UpcomingAdapterDelegate extends WNRAdapterDelegate {

    private static final int UPCOMMING_ITEM = 1;

    public UpcomingAdapterDelegate() {
        super(UPCOMMING_ITEM);
    }

    @Override
    public boolean isForItem(WNRItem item) {
        return item instanceof UpcomingItem;
    }

    @Override
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WNRViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.qplanningapp_upcoming_item, parent, false));
    }
}
