package com.worknrole.framework.permission.activity;

import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.worknrole.framework.permission.eventbus.PermResultEvent;
import com.worknrole.framework.permission.eventbus.PermissionEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by worknrole on 08/03/17.
 *
 * Extends this activity to receive and handle permission events
 * We just need to send event with correct parameters:
 * Events must extends {@link PermissionEvent} class
 */

public abstract class PermissionActivity extends AppCompatActivity {

    @Override
    public void onResume() {
        super.onResume();
        // Register to the event bus
        EventBus.getDefault().register(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Unregister to the event bus
        EventBus.getDefault().unregister(this);
    }

    /**
     * this method intercepts all permission events extending
     * {@link PermissionEvent} class.
     *
     * @param event The permission event asked by an outsider
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPermissionEvent(PermissionEvent event) {
        if (!isPermissionAlreadyGranted(event.getPermissionId())) {
            ActivityCompat.requestPermissions(this,
                    new String[]{event.getPermissionId()},
                    event.getRequestId());
        } else {
            // Inform listeners that this permission is already accepted
            EventBus.getDefault().post(new PermResultEvent(event.getPermissionId(), true));
        }
    }

    /**
     * check if the required permission is already granted
     *
     * @param permissionId The required permissions
     * @return true if the permission is already granted, false otherwise
     */
    private boolean isPermissionAlreadyGranted(String permissionId) {
        return ContextCompat.checkSelfPermission(this, permissionId) == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        boolean isGranted = (grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED);
        // Inform every listeners about the permission result (granted or not)
        EventBus.getDefault().post(new PermResultEvent(permissions[0], isGranted));
    }
}
