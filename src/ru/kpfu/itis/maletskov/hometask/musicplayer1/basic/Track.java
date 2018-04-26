package ru.kpfu.itis.maletskov.hometask.musicplayer1.basic;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.App;

import java.io.File;
import java.io.IOException;

/**
 * Created by Maletskov on 05.03.2018.
 */
public class Track {
    private Mp3File mp3;
    private String title;//title полное название исполнителя и песни
    private String name;//название песни
    private String artist;//имя артиста
    private String[] s;
    private File f;

    public Track(String title) throws InvalidDataException, IOException, UnsupportedTagException {
        this.title = title;
        s = title.split("-");
        this.name = s[1];
        this.artist = s[0];
        f = new File(App.PATH + title + ".mp3");
        mp3 = new Mp3File(f);
    }

    public int getTime() {
        return (int) this.getMp3().getLengthInSeconds();
    }

    public Mp3File getMp3() {
        return mp3;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<< Artist : " + getArtist()
                    + " Tittle : " + getName()).append('\n');
        return sb.toString();
    }
}
