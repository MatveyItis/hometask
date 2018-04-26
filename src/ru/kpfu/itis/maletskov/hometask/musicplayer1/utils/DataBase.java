package ru.kpfu.itis.maletskov.hometask.musicplayer1.utils;

import ru.kpfu.itis.maletskov.hometask.musicplayer1.basic.Playlist;

import java.io.FileNotFoundException;

/**
 * Created by Maletskov on 04.03.2018.
 */
public interface DataBase {
    void save(String s) throws FileNotFoundException;
    void savePlaylist(Playlist playlist);
    String[] findAll();
}
