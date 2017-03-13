package com.worknrole.design.ui.qplanningapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.worknrole.design.ui.qplanningapp.fragment.SocialFragment;
import com.worknrole.design.ui.qplanningapp.fragment.TodaysFragment;

/**
 * Created by worknrole on 13/03/17.
 *
 * Simple slide adapter for {@link TodaysFragment} and {@link TodaysFragment}
 */

public class SlidePagerAdapter extends FragmentStatePagerAdapter {

    //region Constructor
    public SlidePagerAdapter(FragmentManager fm) {
        super(fm);
    }
    //endregion


    //region Pager adapter methods
    @Override
    public Fragment getItem(int position) {
        return position == 0 ? new TodaysFragment() : new SocialFragment();
    }

    @Override
    public int getCount() {
        return 2;
    }
    //endregion
}
