package ru.kpfu.itis.maletskov.hometask.musicplayer.memory;

import ru.kpfu.itis.maletskov.hometask.musicplayer.basic.Playlist;
import ru.kpfu.itis.maletskov.hometask.musicplayer.basic.Track;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maletskov on 28.02.2018.
 */
public class MemoryDataBase implements DataBase {
    private List<Track> list;
    private List<Playlist> playlists;

    private MemoryDataBase() {
        list = new ArrayList<>();
        playlists = new ArrayList<>();
    }

    private static class MemoryDataBaseHolder {
        private final static MemoryDataBase db = new MemoryDataBase();
    }

    public static MemoryDataBase getDb() {
        return MemoryDataBaseHolder.db;
    }

    @Override
    public void save(Track track) {
        boolean b = false;
        for (Track t : list) {
            if (track.equals(t)){
                b = true;
                break;
            }
        }
        if (!b) {
            list.add(track);
        }
    }

    @Override
    public void savePlaylist(Playlist playlist) {
        boolean b = false;
        for (int i = 0; i < playlists.size(); i++) {
            if (playlist.getNamePlaylist().equals(playlists.get(i).getNamePlaylist())) {
                b = true;
                break;
            }
        }
        if (!b) {
            playlists.add(playlist);
        }
    }

    @Override
    public Track[] findAll() {
        Track[] t = new Track[list.size()];
        for (int i = 0; i < t.length; i++) {
            t[i] = list.get(i);
        }
        return t;
    }

    @Override
    public String toString() {
        //return Arrays.toString(findAll());
        StringBuilder sb = new StringBuilder();
        for (Track t : list) {
            sb.append(t.toString()).append('\n');
        }
        return sb.toString();
    }
}
