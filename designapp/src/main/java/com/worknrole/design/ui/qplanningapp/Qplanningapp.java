package com.worknrole.design.ui.qplanningapp;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by worknrole on 14/03/17.
 *
 * QPlanningApp constants:
 *  - RecyclerView item type
 */

public class Qplanningapp {

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({CALENDAR_ITEM, SOCIAL_ITEM, TODAYS_ITEM, UPCOMING_ITEM})
    public @interface ItemType {}
    public static final int CALENDAR_ITEM = 0;
    public static final int SOCIAL_ITEM = 1;
    public static final int TODAYS_ITEM = 2;
    public static final int UPCOMING_ITEM = 3;
}
