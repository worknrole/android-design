package com.worknrole.framework.util;

import android.util.Log;

/**
 * Created by worknrole on 13/01/17.
 */

public class WNRLog {

    private static final boolean ENABLE_LOG = true;

    public static void debug(Class clazz, String message) {
        if(ENABLE_LOG) Log.d(clazz.getSimpleName() + "_WNRDebug", message);
    }

    public static void warning(Class clazz, String message) {
        if(ENABLE_LOG) Log.w(clazz.getSimpleName() + "_WNRWarn", message);
    }

    public static void error(Class clazz, String message) {
        if(ENABLE_LOG) Log.e(clazz.getSimpleName() + "_WNRError", message);
    }
}
