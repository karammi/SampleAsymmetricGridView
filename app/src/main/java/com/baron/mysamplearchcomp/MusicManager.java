package com.baron.mysamplearchcomp;

import android.content.Context;
import android.media.MediaPlayer;

public class MusicManager {

    private Context context;
    private MediaPlayer mediaPlayer;

    public MusicManager(Context context) {
        this.context = context;
        mediaPlayer = MediaPlayer.create(context, R.raw.shadmehr);

    }

    public void start() {
        mediaPlayer.start();
    }

    public void pause() {
        mediaPlayer.pause();
    }

    public void stop() {
        mediaPlayer.stop();
        mediaPlayer.release();
    }


}
