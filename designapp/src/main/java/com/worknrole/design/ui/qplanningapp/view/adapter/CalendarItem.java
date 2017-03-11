package com.worknrole.design.ui.qplanningapp.view.adapter;

import com.worknrole.framework.view.recyclerview.item.WNRItem;

/**
 * Created by worknrole on 10/03/17.
 */

public class CalendarItem extends WNRItem {

    private String mTitle;

    public CalendarItem(String title) {
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
