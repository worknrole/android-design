package com.worknrole.framework.permission.eventbus;

import com.worknrole.framework.permission.Perm;

/**
 * Created by worknrole on 08/03/17.
 *
 * Class sent after a permission request
 */

public class PermResultEvent {

    //region Properties
    /**
     * The permission id
     */
    private @Perm.PermissionId String mPermissionId;
    /**
     * Tells if the permission has been granted
     */
    private boolean mIsGranted;
    //endregion


    //region Constructor

    /**
     * A Basic constructor setting permission and access
     *
     * @param permissionId The permission id
     * @param isGranted access value
     */
    public PermResultEvent(@Perm.PermissionId String permissionId, boolean isGranted) {
        mPermissionId = permissionId;
        mIsGranted = isGranted;
    }
    //endregion


    //region Accessors

    /**
     * Return the permission request id
     * @return the permission request id
     */
    public String getPermissionId() {
        return mPermissionId;
    }

    /**
     * Tells if the permission has been granted
     * @return true if granted, false otherwise
     */
    public boolean isGranted() {
        return mIsGranted;
    }
    //endregion
}
