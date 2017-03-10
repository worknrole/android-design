package com.worknrole.framework.view.recyclerview.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by worknrole on 16/01/17.
 *
 * My generic ViewHolder used to holding a specific view
 */

public class WNRViewHolder extends RecyclerView.ViewHolder {

    //region Properties
    /**
     * The view holding by this ViewHolder
     */
    private View mItemView;
    //endregion


    //region Constructor
    /**
     * A simple constructor
     * @param itemView The view of a specific item
     */
    public WNRViewHolder(View itemView) {
        super(itemView);
        mItemView = itemView;
    }
    //endregion


    //region Accessor
    /**
     * Get the view holding by this ViewHolder
     * @return The view holding by this ViewHolder
     */
    public View getItemView() {
        return mItemView;
    }
    //endregion
}
