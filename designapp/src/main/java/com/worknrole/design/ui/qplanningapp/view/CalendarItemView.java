package com.worknrole.design.ui.qplanningapp.view;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.item.CalendarItem;
import com.worknrole.framework.view.recyclerview.view.ItemViewUpdater;

import java.util.Arrays;

import butterknife.BindArray;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by worknrole on 10/03/17.
 */

public class CalendarItemView extends LinearLayout implements ItemViewUpdater<CalendarItem> {

    @BindView(R.id.title)
    TextView mTitle;

    @BindArray(R.array.calendar_day)
    String[] mCalendarDay;

    private boolean mIsNumeric;

    public CalendarItemView(Context context) {
        super(context);
    }

    public CalendarItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalendarItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CalendarItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    @Override
    public void updateView(CalendarItem item) {
        if (item != null) {
            String day = item.getTitle();
            mTitle.setText(day);
            if (Arrays.asList(mCalendarDay).contains(day)) {
                mIsNumeric = true;
                mTitle.setTypeface(null, Typeface.BOLD);
            }
        }
    }

    @OnClick(R.id.calendar_item)
    public void onClick() {
        if (!mIsNumeric) {
            //TODO select
        }
    }
}
