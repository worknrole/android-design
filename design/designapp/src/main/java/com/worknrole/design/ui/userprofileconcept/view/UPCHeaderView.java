package com.worknrole.design.ui.userprofileconcept.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

/**
 * Created by worknrole on 21/01/17.
 *
 * The header view
 */
public class UPCHeaderView extends RelativeLayout {

    public UPCHeaderView(Context context) {
        super(context);
    }

    public UPCHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public UPCHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public UPCHeaderView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
