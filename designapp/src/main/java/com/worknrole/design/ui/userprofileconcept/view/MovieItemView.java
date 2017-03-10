package com.worknrole.design.ui.userprofileconcept.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.worknrole.design.R;
import com.worknrole.design.ui.userprofileconcept.item.MovieItem;
import com.worknrole.framework.view.recyclerview.view.ItemViewUpdater;

/**
 * Created by worknrole on 21/01/17.
 *
 * The view matching the {@link MovieItem}
 * We need to implements the {@link ItemViewUpdater} to allow the item binding
 */

public class MovieItemView extends LinearLayout implements ItemViewUpdater<MovieItem> {

    //region Properties
    /**
     * The movie picture view
     */
    private ImageView mMoviePicture;
    //endregion


    //region Constructors
    public MovieItemView(Context context) {
        super(context);
    }

    public MovieItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MovieItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MovieItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //endregion


    //region Lifecycle
    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mMoviePicture = (ImageView) findViewById(R.id.upc_movieImage);
    }
    //endregion


    //region Custom methods
    @Override
    public void updateView(MovieItem item) {
        @DrawableRes int drawableId = item.getmDrawableId();
        if (drawableId > 0) {
            mMoviePicture.setImageDrawable(ContextCompat.getDrawable(getContext(), drawableId));
        }
    }
    //endregion
}
