package com.baron.mysamplearchcomp;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.util.Log;

public class MusicObserver implements LifecycleObserver {

    private Context context;
    public static final String TAG = "MainActivity";

    private MusicManager musicManager;

    public MusicObserver(Context context) {
        this.context = context;
        musicManager = new MusicManager(context);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private void timeToStartMusic() {
        Log.e(TAG, "listeningToStart: Observer Create");
        musicManager.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private void listningToStart() {
        Log.e(TAG, "listeningToStart: Observer Start");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private void pause() {
        Log.e(TAG, "listeningToStart: Observer Pause");
        musicManager.pause();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private void resume() {
        Log.e(TAG, "listeningToStart: Observer Resume");
        musicManager.start();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private void listningToStop(){
        Log.e(TAG, "listeningToStart: Observer Stop" );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private void destroy() {
        Log.e(TAG, "listeningToStart: Observer Destroy");
        musicManager.stop();
    }

}
