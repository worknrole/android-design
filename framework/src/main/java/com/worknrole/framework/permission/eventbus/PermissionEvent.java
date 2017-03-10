package com.worknrole.framework.permission.eventbus;

/**
 * Created by worknrole on 08/03/17.
 *
 * Mother class of Permission event
 */

public abstract class PermissionEvent {

    //region Properties
    /**
     * The request ID (all are defined in {@link com.worknrole.framework.permission.Perm.RequestId}
     */
    private int mRequestId;
    /**
     * The permission ID (all are (re-)defined in {@link com.worknrole.framework.permission.Perm.PermissionId}
     */
    private String mPermissionId;
    //endregion


    //region Constructors

    /**
     * A basic constructor setting request and permission ID
     * @param requestId The request Id
     * @param permissionId The required permission Id
     */
    public PermissionEvent(int requestId, String permissionId) {
        mRequestId = requestId;
        mPermissionId = permissionId;
    }
    //endregion


    //region Accessors

    /**
     * Return the permission request id
     * @return the permission request id
     */
    public int getRequestId() {
        return mRequestId;
    }

    /**
     * Return the permission id
     * @return the permission id
     */
    public String getPermissionId() {
        return mPermissionId;
    }
    //endregion
}
