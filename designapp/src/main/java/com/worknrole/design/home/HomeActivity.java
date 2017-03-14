package com.worknrole.design.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.worknrole.design.R;
import com.worknrole.design.ui.userprofileconcept.UPCActivity;
import com.worknrole.design.ui.qplanningapp.QPlanningAppActivity;
import com.worknrole.framework.view.recyclerview.adapter.WNRAdapter;
import com.worknrole.framework.view.recyclerview.item.WNRItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    //region Properties
    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    //endregion


    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_layout);
        ButterKnife.bind(this);

        initRecyclerView();
    }
    //endregion


    //region Initializer
    private void initRecyclerView() {
        WNRAdapter adapter = new WNRAdapter();
        adapter.addAdapterDelegate(new HomeItemAdapterDelegate());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        List<WNRItem> items = new ArrayList<>();
        items.add(new HomeItem(getString(R.string.title_activity_upc), UPCActivity.class));
        items.add(new HomeItem(getString(R.string.qplanningapp_title_activity), QPlanningAppActivity.class));
        adapter.addItems(items);
    }
    //endregion
}
