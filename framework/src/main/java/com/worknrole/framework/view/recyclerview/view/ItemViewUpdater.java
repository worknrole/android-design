package com.worknrole.framework.view.recyclerview.view;

import com.worknrole.framework.view.recyclerview.item.WNRItem;

/**
 * Created by worknrole on 16/01/17.
 *
 * An interface used to allow a my RecyclerView item view to
 * bind a specific item to it's specific view
 */

public interface ItemViewUpdater<ItemType extends WNRItem> {
    /**
     * Used to bind an item to it's custom view
     * @param item  The item to bind
     */
    void updateView(ItemType item);
}
