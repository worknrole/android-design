package com.worknrole.framework.permission;

import android.Manifest;
import android.support.annotation.IntDef;
import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by worknrole on 08/03/17.
 *
 * Provide constant request ID for permission
 */

public class Perm {

    @Retention(RetentionPolicy.SOURCE)
    @StringDef({ACCESS_FINE_LOCATION})
    public @interface PermissionId {}
    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({ACCESS_FINE_LOCATION_REQUEST})
    public @interface RequestId {}
    public static final int ACCESS_FINE_LOCATION_REQUEST = 0;
}
