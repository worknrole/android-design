package com.worknrole.framework.view.recyclerview.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.worknrole.framework.R;
import com.worknrole.framework.view.recyclerview.item.WNRItem;
import com.worknrole.framework.view.recyclerview.view.ItemViewUpdater;
import com.worknrole.framework.view.recyclerview.view.WNRViewHolder;

/**
 * Created by worknrole on 16/01/17.
 *
 * An adapter delegate used to manage specific item for specific view
 *
 * To use an adapter delegate, we need to extend it and add it to the
 * {@link WNRAdapterDelegateManager} through the
 * {@link WNRAdapter#addAdapterDelegate(WNRAdapterDelegate)} method
 */

public abstract class WNRAdapterDelegate<ItemType extends WNRItem> {

    //region Properties
    /**
     * The item view type manages by this delegate
     */
    private int mViewType;
    //endregion


    //region Constructor
    /**
     * A simple constructor setting a specific view type to manage
     * @param viewType  The view type manage by this delegate
     */
    public WNRAdapterDelegate(int viewType) {
        mViewType = viewType;
    }
    //endregion


    //region Creation
    /**
     *  Check if the current item is manage by this delegate
     * @param item  The item to check
     * @return      true if this delegate manage this type of item, false otherwise
     */
    public abstract boolean isForItem(ItemType item);

    /**
     * Return the item view type manage by this delegate
     * @return the item view type manage by this delegate
     */
    public int getItemViewType() {
        return mViewType;
    }

    /**
     * Create a custom ViewHolder for the current view type
     * @param parent        The parent view
     * @param viewType      The current item view type
     * @return a custom ViewHolder for the current view type
     */
    public WNRViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WNRViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.recycler_item_view_default, parent, false));
    }

    /**
     * Used to bind the current item to the specific view
     * @param viewHolder    The ViewHolder containing the desire view
     * @param item          The current item to bind
     */
    public void onBinViewHolder(WNRViewHolder viewHolder, ItemType item) {
        View view = viewHolder.getItemView();
        if (view != null && view instanceof ItemViewUpdater) {
            ((ItemViewUpdater)view).updateView(item);
        }
    }
    //endregion
}
