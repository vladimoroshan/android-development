package com.atul.audioplayer.listener;

import com.atul.audioplayer.model.Music;

import java.util.List;

public interface MusicSelectListener {
    void playQueue(List<Music> musicList);

    void setShuffleMode(boolean mode);
}