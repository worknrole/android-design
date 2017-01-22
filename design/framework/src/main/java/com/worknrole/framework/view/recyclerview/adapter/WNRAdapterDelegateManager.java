package com.worknrole.framework.view.recyclerview.adapter;

import android.util.SparseArray;
import android.view.ViewGroup;

import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 16/01/17.
 *
 * The manager containing all adapter delegate
 * It's manage the delegation process between specific adapter, item type and custom views
 */

class WNRAdapterDelegateManager<ItemType extends WNRItem> {

    //region Properties
    /**
     * All custom adapter delegates used
     */
    private SparseArray<WNRAdapterDelegate> mAdapterDelegateList;
    //endregion


    //region Constructor
    /**
     * A simple constructor
     */
    public WNRAdapterDelegateManager() {
        mAdapterDelegateList = new SparseArray<WNRAdapterDelegate>();
    }
    //endregion


    //region Creation

    /**
     * Add a new adapter delegate if it doesn't already exist
     * @param newDelegate
     */
    public void addAdapter(WNRAdapterDelegate newDelegate) {
        if (mAdapterDelegateList.indexOfValue(newDelegate) < 0) {
            mAdapterDelegateList.put(newDelegate.getItemViewType(), newDelegate);
        }
    }

    /**
     * Get the view type of an item according to it's adapter delegate
     * @param item The item where find it's type
     * @return The item view type
     */
    public int getItemViewType(ItemType item) {
        int viewType = 0;
        for (int index=0; index<mAdapterDelegateList.size(); index++) {
            WNRAdapterDelegate delegate = mAdapterDelegateList.get(index);
            if (delegate != null && delegate.isForItem(item)) {
                viewType = delegate.getItemViewType();
                break;
            }
        }
        return viewType;
    }

    /**
     * Use to create a view holder according to it's type
     * @param parent    The view parent
     * @param viewType  The item view type
     * @return A {@link WNRViewHolder} created according to the item view type
     */
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        WNRAdapterDelegate delegate = null;
        if ((delegate = mAdapterDelegateList.get(viewType)) == null) {
            throw new NullPointerException("[onCreateViewHolder] This view type has no adapter delegate associated");
        }
        return delegate.onCreateViewHolder(parent, viewType);
    }

    /**
     * Use to bind the current item to it's specific view
     * @param holder    The ViewHolder containing the desire view
     * @param item      The item to bind to the view
     */
    public void onBindViewHolder(WNRViewHolder holder, ItemType item) {
        boolean foundDelegate = false;
        for (int index=0; index < mAdapterDelegateList.size(); index++) {
            WNRAdapterDelegate delegate = mAdapterDelegateList.get(index);
            if (delegate != null && delegate.isForItem(item)) {
                foundDelegate = true;
                delegate.onBinViewHolder(holder, item);
                break;
            }
        }

        if(!foundDelegate) {
            throw new NullPointerException("[onBindViewHolder] This view holder has no adapter delegate associated");
        }
    }
    //endregion
}
