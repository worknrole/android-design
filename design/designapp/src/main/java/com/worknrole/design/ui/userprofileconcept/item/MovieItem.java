package com.worknrole.design.ui.userprofileconcept.item;

import android.support.annotation.DrawableRes;

import com.worknrole.framework.view.recyclerview.item.WNRItem;

/**
 * Created by worknrole on 21/01/17.
 *
 * A very simple movie item
 */

public class MovieItem extends WNRItem {

    //region Properties
    /**
     * The static image used for testing the item view
     */
    private @DrawableRes int mDrawableId;
    //endregion


    //region Constructor
    public MovieItem(@DrawableRes int drawableId) {
        mDrawableId = drawableId;
    }
    //endregion


    //region Accessors
    public @DrawableRes int getmDrawableId() {
        return mDrawableId;
    }

    public void setmDrawableId(@DrawableRes int mDrawableId) {
        this.mDrawableId = mDrawableId;
    }
    //endregion
}
