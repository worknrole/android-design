package com.worknrole.design.ui.qplanningapp.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.item.CalendarItem;
import com.worknrole.design.ui.qplanningapp.item.TodayItem;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapterDelegate;
import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 13/03/17.
 */

public class TodayAdapterDelegate extends WNRAdapterDelegate {

    private static final int TODAY_ITEM = 0;
    private static final int UPCOMMING_ITEM = 1;

    public TodayAdapterDelegate() {
        super(TODAY_ITEM);
    }

    @Override
    public boolean isForItem(WNRItem item) {
        return item instanceof TodayItem;
    }

    @Override
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WNRViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.qplanningapp_today_item, parent, false));
    }
}
