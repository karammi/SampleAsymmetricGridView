package com.baron.mysamplearchcomp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class LifecycleAwareLogging implements LifecycleObserver {

    public static final String TAG = "LifeCycleAware";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void listeningToCreate() {
        Log.e(TAG, "listeningToCreate: " + " OnCreate() ");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void listeningToDestroy() {
        Log.e(TAG, "listeningToDestroy: " + "OnDestroy");
    }
}
