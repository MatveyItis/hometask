package ru.kpfu.itis.maletskov.hometask.musicplayer1.basic;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.util.HashMap;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Maletskov on 04.03.2018.
 */
public class Playlist {
    private Map<String, Mp3File> map;
    private String name;

    public Playlist(String name) {
        this.name = name;
        this.map = new HashMap<>();
    }

    public void addToPlaylist(String s) {
        try {
            if (name == null) {
                System.err.println("Playlist had not created");
            }
            File f = new File(App.PATH + s + ".mp3");
            Mp3File mp3 = new Mp3File(f);
            map.put(s, mp3);
            System.out.println("Song is added");

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please enter the right name of song!");
        } catch (UnsupportedTagException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidDataException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }
}
