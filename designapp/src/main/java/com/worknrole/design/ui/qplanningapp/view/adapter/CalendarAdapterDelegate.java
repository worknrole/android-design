package com.worknrole.design.ui.qplanningapp.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapterDelegate;
import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 10/03/17.
 */

public class CalendarAdapterDelegate extends WNRAdapterDelegate {

    private static final int DAY_ITEM = 0;

    public CalendarAdapterDelegate() {
        super(DAY_ITEM);
    }

    @Override
    public boolean isForItem(WNRItem item) {
        return item instanceof CalendarItem;
    }

    @Override
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WNRViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.qplanningapp_calendar_item, parent, false));
    }
}
