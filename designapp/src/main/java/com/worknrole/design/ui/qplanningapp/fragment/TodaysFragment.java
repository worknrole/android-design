package com.worknrole.design.ui.qplanningapp.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.adapter.CalendarAdapterDelegate;
import com.worknrole.design.ui.qplanningapp.adapter.TodayAdapterDelegate;
import com.worknrole.design.ui.qplanningapp.adapter.UpcomingAdapterDelegate;
import com.worknrole.design.ui.qplanningapp.item.CalendarItem;
import com.worknrole.design.ui.qplanningapp.item.TodayItem;
import com.worknrole.design.ui.qplanningapp.item.UpcomingItem;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapter;
import com.worknrole.framework.view.recyclerview.item.WNRItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by worknrole on 11/03/17.
 */

public class TodaysFragment extends Fragment {

    //region Properties
    @BindView(R.id.recycler_view_calendar)
    RecyclerView mRecyclerViewCalendar;

    @BindView(R.id.recycler_view_plan)
    RecyclerView mRecyclerViewPlan;
    //endregion


    //region Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.qplanningapp_fragment_todays, container, false);
        ButterKnife.bind(this, rootView);
        initialize();
        return rootView;
    }
    //endregion


    //region Initializer
    private void initialize() {
        // Create Calendar
        WNRAdapter adapter = new WNRAdapter();
        adapter.addAdapterDelegate(new CalendarAdapterDelegate());
        mRecyclerViewCalendar.setAdapter(adapter);
        mRecyclerViewCalendar.setLayoutManager(new GridLayoutManager(getContext(), 7));

        List<WNRItem> items = new ArrayList<>();
        items.add(new CalendarItem("S"));
        items.add(new CalendarItem("M"));
        items.add(new CalendarItem("T"));
        items.add(new CalendarItem("W"));
        items.add(new CalendarItem("T"));
        items.add(new CalendarItem("F"));
        items.add(new CalendarItem("S"));
        items.add(new CalendarItem(""));
        items.add(new CalendarItem(""));
        items.add(new CalendarItem(""));
        items.add(new CalendarItem(""));
        items.add(new CalendarItem(""));

        for (int i=1; i<=30; i++) {
            items.add(new CalendarItem(Integer.toString(i)));
        }

        adapter.addItems(items);



        // Create Plan
        WNRAdapter adapterPlan = new WNRAdapter();
        adapterPlan.addAdapterDelegate(new TodayAdapterDelegate());
        adapterPlan.addAdapterDelegate(new UpcomingAdapterDelegate());
        mRecyclerViewPlan.setAdapter(adapterPlan);
        mRecyclerViewPlan.setLayoutManager(new LinearLayoutManager(getContext()));

        List<WNRItem> itemsPlan = new ArrayList<>();
        itemsPlan.add(new TodayItem());
        itemsPlan.add(new UpcomingItem());
        adapterPlan.addItems(itemsPlan);
    }
    //endregion
}
