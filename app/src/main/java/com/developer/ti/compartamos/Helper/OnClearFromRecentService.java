package com.developer.ti.compartamos.Helper;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by tecnicoairmovil on 14/06/17.
 */

public class OnClearFromRecentService extends Service {
    public static final String TAG = OnClearFromRecentService.class.getSimpleName();
    private MySharePreferences mySharePreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        mySharePreferences = MySharePreferences.getInstance(getApplicationContext());
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "Service Started");
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mySharePreferences.setInit(false);
        Log.d(TAG, "Service Destroyed");
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        Log.e(TAG, "END");
        mySharePreferences.setInit(false);
        stopSelf();
    }
}