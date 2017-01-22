package com.worknrole.design.ui.userprofileconcept.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.worknrole.design.R;
import com.worknrole.design.ui.userprofileconcept.item.MovieAdapterDelegate;
import com.worknrole.design.ui.userprofileconcept.item.MovieItem;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/**
 * Created by worknrole on 21/01/17.
 *
 * The content view
 */

public class UPCContentView extends RelativeLayout {

    //region Properties
    private RecyclerView    mRecyclerView;
    private WNRAdapter      mAdapter;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({MOVIE})
    public @interface RVViewType {}
    public static final int MOVIE = 0;
    //endregion


    //region Constructors
    public UPCContentView(Context context) {
        super(context);
    }

    public UPCContentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UPCContentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UPCContentView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    //endregion


    //region Lifecycle
    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        mRecyclerView = (RecyclerView) findViewById(R.id.upc_recyclerView);
        mAdapter = new WNRAdapter();
        mAdapter.addAdapterDelegate(new MovieAdapterDelegate(MOVIE));
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int currentItemPosition = parent.getChildAdapterPosition(view);
                if (currentItemPosition == 0) {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.upc_dimenFirstRVItemOffsets);
                } else if (currentItemPosition == (mAdapter.getItemCount() - 1)) {
                    outRect.right = getResources().getDimensionPixelOffset(R.dimen.upc_dimenFirstRVItemOffsets);
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.upc_dimenRVItemOffsets);
                } else {
                    outRect.left = getResources().getDimensionPixelOffset(R.dimen.upc_dimenRVItemOffsets);
                }
            }
        });
    }
    //endregion


    //region Custom methods
    public void addMovies(List<MovieItem> moviesList) {
        if (moviesList != null && !moviesList.isEmpty()) {
            mAdapter.addItems(moviesList);
        }
    }
    //endregion
}
