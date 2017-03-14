package com.worknrole.design.ui.qplanningapp.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.item.CalendarItem;
import com.worknrole.design.ui.qplanningapp.item.SocialItem;
import com.worknrole.framework.view.recyclerview.view.ItemViewUpdater;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by worknrole on 13/03/17.
 *
 * View of a {@link SocialItemView}
 */

public class SocialItemView extends CardView implements ItemViewUpdater<SocialItem> {

    //region Properties
    @BindView(R.id.picture)
    ImageView mPicture;

    @BindView(R.id.name)
    TextView mName;

    @BindView(R.id.description)
    TextView mDescription;

    @BindView(R.id.date)
    TextView mDate;
    //endregion


    //region Constructors
    public SocialItemView(Context context) {
        super(context);
    }

    public SocialItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public SocialItemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    //endregion


    //region Lifecycle Updater
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    @Override
    public void updateView(SocialItem item) {
        if (item != null) {
            mName.setText(item.getName());
            mDescription.setText(item.getDescription());
            mDate.setText(item.getDate());
            Picasso.with(getContext())
                    .load(item.getPicture())
                    .into(mPicture);
        }
    }
    //endregion
}
