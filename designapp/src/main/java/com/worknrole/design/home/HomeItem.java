package com.worknrole.design.home;

import com.worknrole.framework.view.recyclerview.item.WNRItem;

/**
 * Created by worknrole on 10/03/17.
 */

public class HomeItem extends WNRItem {

    private Class mClazz;
    private String mTitle;

    public HomeItem(String title, Class clazz) {
        mTitle = title;
        mClazz = clazz;
    }

    public Class getClazz() {
        return mClazz;
    }

    public void setClazz(Class clazz) {
        mClazz = clazz;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }
}
