package com.worknrole.design.ui.qplanningapp.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.view.adapter.CalendarAdapterDelegate;
import com.worknrole.design.ui.qplanningapp.view.adapter.CalendarItem;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapter;
import com.worknrole.framework.view.recyclerview.item.WNRItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by worknrole on 10/03/17.
 */

public class QPALayout extends RelativeLayout {

    //region Properties
    @BindView(R.id.recycler_view_calendar)
    RecyclerView mRecyclerView;
    //endregion


    //region Constructors
    public QPALayout(Context context) {
        super(context);
    }

    public QPALayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public QPALayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public QPALayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //endregion


    //region Lifecycle
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);

        initialize();
    }
    //endregion


    //region Initializer
    private void initialize() {
        WNRAdapter adapter = new WNRAdapter();
        adapter.addAdapterDelegate(new CalendarAdapterDelegate());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(), 7));

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
    }
    //endregion
}
