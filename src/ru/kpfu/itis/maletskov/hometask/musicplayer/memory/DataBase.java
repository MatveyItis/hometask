package ru.kpfu.itis.maletskov.hometask.musicplayer.memory;

import ru.kpfu.itis.maletskov.hometask.musicplayer.basic.Playlist;
import ru.kpfu.itis.maletskov.hometask.musicplayer.basic.Track;

/**
 * Created by Maletskov on 01.03.2018.
 */
public interface DataBase {
    void save(Track track);
    void savePlaylist(Playlist playlist);
    Track[] findAll();
}
