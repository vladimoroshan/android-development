package com.atul.audioplayer.helper;

import com.atul.audioplayer.model.Music;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class ListHelper {

    public static List<Music> searchMusicByName(List<Music> list, String query) {
        List<Music> newList = new ArrayList<>(list);
        return CollectionsKt.filter(newList, music ->
                (music.title.toLowerCase().contains(query) || music.displayName.toLowerCase().contains(query)) ||
                        (music.artist.toLowerCase().contains(query) || music.album.toLowerCase().contains(query))
        );
    }


    public static String ifNull(String val) {
        return val == null ? "" : val;
    }
}
