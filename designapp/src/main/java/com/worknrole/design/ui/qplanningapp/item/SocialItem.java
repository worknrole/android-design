package com.worknrole.design.ui.qplanningapp.item;

import android.support.annotation.DrawableRes;

import com.worknrole.framework.view.recyclerview.item.WNRItem;

/**
 * Created by worknrole on 13/03/17.
 */

public class SocialItem extends WNRItem {

    private @DrawableRes int mPicture;
    private String mName;
    private String mDescription;
    private String mDate;

    public SocialItem(String name, @DrawableRes int pictureRes, String description, String date) {
        mName = name;
        mPicture = pictureRes;
        mDescription = description;
        mDate = date;
    }

    public int getPicture() {
        return mPicture;
    }

    public String getName() {
        return mName;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getDate() {
        return mDate;
    }
}
