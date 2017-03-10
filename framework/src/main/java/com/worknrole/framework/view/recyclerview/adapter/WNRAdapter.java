package com.worknrole.framework.view.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by worknrole on 16/01/17.
 *
 * My generic RecyclerView adapter
 * Use a {@link WNRAdapterDelegateManager} containing 1..* {@link WNRAdapterDelegate}
 * to create specific adapter to specific items and views
 *
 * ~ Many things to add and update ~
 */

public class WNRAdapter<ItemType extends WNRItem> extends RecyclerView.Adapter<WNRViewHolder> {

    //region Properties
    /**
     * All items used to update my {@link RecyclerView}
     */
    private List<ItemType> mItems;

    /**
     * A manager used to simplify the delegation process
     */
    private WNRAdapterDelegateManager mDelegateManager;
    //endregion


    //region Constructor
    /**
     * Simple constructor
     */
    public WNRAdapter() {
        mItems = new ArrayList<ItemType>();
        mDelegateManager = new WNRAdapterDelegateManager();
    }
    //endregion


    //region Initializer
    /**
     * Add new items to the adapter and notify the main view
     * @param items All new items to add
     */
    public void addItems(List<ItemType> items) {
        int positionStart = mItems.size();
        mItems.addAll(items);
        notifyItemRangeInserted(positionStart, items.size());
    }

    /**
     * Add specific adapter delegate to manage new item and view
     * @param delegate The new adapter delegate to add
     */
    public void addAdapterDelegate(WNRAdapterDelegate delegate) {
        mDelegateManager.addAdapter(delegate);
    }
    //endregion


    //region View creation
    @Override
    public int getItemViewType(int position) {
        return mDelegateManager.getItemViewType(mItems.get(position));
    }

    @Override
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return mDelegateManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(WNRViewHolder holder, int position) {
        mDelegateManager.onBindViewHolder(holder, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
    //endregion
}
