package com.worknrole.design.ui.qplanningapp.fragment;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.worknrole.design.R;
import com.worknrole.design.ui.qplanningapp.adapter.SocialAdapterDelegate;
import com.worknrole.design.ui.qplanningapp.item.SocialItem;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapter;
import com.worknrole.framework.view.recyclerview.item.WNRItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by worknrole on 13/03/17.
 */

public class SocialFragment extends Fragment {

    //region Properties
    @BindView(R.id.recycler_view_social)
    RecyclerView mRecyclerView;
    //endregion


    //region Lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.qplanningapp_fragment_social, container, false);
        ButterKnife.bind(this, rootView);
        initialize();
        return rootView;
    }
    //endregion


    //region Initializer
    private void initialize() {
        WNRAdapter adapter = new WNRAdapter();
        adapter.addAdapterDelegate(new SocialAdapterDelegate());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                int currentChildPosition = parent.getChildAdapterPosition(view);
                if (currentChildPosition == 0) {
                    outRect.top = getContext().getResources().getDimensionPixelOffset(R.dimen.social_recycler_view_margin);
                }
                else if (currentChildPosition == parent.getAdapter().getItemCount() - 1) {
                    outRect.bottom = getContext().getResources().getDimensionPixelOffset(R.dimen.social_recycler_view_margin);
                }
            }
        });

        List<WNRItem> items = new ArrayList<>();
        items.add(new SocialItem(getString(R.string.social_name_1), R.drawable.scarlette_johanson, getString(R.string.social_description_1), getString(R.string.social_date_1)));
        items.add(new SocialItem(getString(R.string.social_name_2), R.drawable.robert_downey_jr, getString(R.string.social_description_2), getString(R.string.social_date_2)));
        items.add(new SocialItem(getString(R.string.social_name_3), R.drawable.chris_evans, getString(R.string.social_description_3), getString(R.string.social_date_3)));
        items.add(new SocialItem(getString(R.string.social_name_4), R.drawable.chris_hemsworth, getString(R.string.social_description_4), getString(R.string.social_date_4)));
        items.add(new SocialItem(getString(R.string.social_name_5), R.drawable.gwyneth_paltrow, getString(R.string.social_description_5), getString(R.string.social_date_5)));
        adapter.addItems(items);
    }
    //endregion
}