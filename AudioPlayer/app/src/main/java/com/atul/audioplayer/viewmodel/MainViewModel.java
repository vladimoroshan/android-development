package com.atul.audioplayer.viewmodel;

import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.atul.audioplayer.MPPreferences;
import com.atul.audioplayer.helper.MusicLibraryHelper;
import com.atul.audioplayer.model.Album;
import com.atul.audioplayer.model.Artist;
import com.atul.audioplayer.model.Folder;
import com.atul.audioplayer.model.Music;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class MainViewModel extends ViewModel {

    public List<Music> songsList = new ArrayList<>();
    public List<Album> albumList = new ArrayList<>();
    public List<Artist> artistList = new ArrayList<>();
    public List<Folder> folderList = new ArrayList<>();

    public MainViewModel(Context context) {
        initSongList(context);
    }

    private void initSongList(Context context) {
        Set<String> excludedFolderList = MPPreferences.getExcludedFolders(context);
        List<Music> musicList = MusicLibraryHelper.fetchMusicLibrary(context);
        HashMap<String, Folder> map = new HashMap<>();

        for (Music music : musicList) {
            Folder folder;
            if (map.containsKey(music.relativePath)) {
                folder = map.get(music.relativePath);
                assert folder != null;
                folder.songsCount += 1;
            } else {
                folder = new Folder(1, music.relativePath);
                folderList.add(folder);
            }
            map.put(music.relativePath, folder);
        }

        for (Music music : musicList) {
            if (!excludedFolderList.contains(music.relativePath))
                songsList.add(music);
        }

    }

    public List<Music> getSongs(boolean reverse) {
        if (reverse)
            Collections.reverse(songsList);

        return songsList;
    }

}

