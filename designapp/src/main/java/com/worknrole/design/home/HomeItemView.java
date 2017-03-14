package com.worknrole.design.home;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.worknrole.design.R;
import com.worknrole.framework.view.recyclerview.view.ItemViewUpdater;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by worknrole on 10/03/17.
 */

public class HomeItemView extends LinearLayout implements ItemViewUpdater<HomeItem> {

    @BindView(R.id.title)
    TextView mTitle;
    private Class mClass;

    public HomeItemView(Context context) {
        super(context);
    }

    public HomeItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public HomeItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public HomeItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    @Override
    public void updateView(HomeItem item) {
        if (item != null) {
            mTitle.setText(item.getTitle());
            mClass = item.getClazz();
        }
    }

    @OnClick(R.id.home_item)
    public void onClick() {
        if (mClass != null) {
            getContext().startActivity(new Intent(getContext(), mClass));
        }
    }
}
