package ru.kpfu.itis.maletskov.hometask.musicplayer.basic;

import ru.kpfu.itis.maletskov.hometask.musicplayer.memory.MemoryDataBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Maletskov on 28.02.2018.
 */
public class Playlist {
    private List<Track> playlist;
    private Track track;
    private String namePlaylist;

    public Playlist(String namePlaylist) {
        this.namePlaylist = namePlaylist;
        playlist = new ArrayList<>();
    }

    public Playlist() {
        playlist = new ArrayList<>();
    }

    public void add(Track tr) {
        /*boolean b = false;
        for (Track t : playlist) {
            if (tr.equals(t)){
                b = true;
                break;
            }
        }
        if (b) {
            return false;
        } else {
            playlist.add(tr);
            return true;
        }
        */
    }

    public String getNamePlaylist() {
        return namePlaylist;
    }

    @Override
    public String toString() {
        /*StringBuilder sb = new StringBuilder();
        for (Track t : playlist) {
            sb.append(t.toString()).append('\n');
        }
        return sb.toString();
        */
        return null;
    }
}
