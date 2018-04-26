package ru.kpfu.itis.maletskov.hometask.musicplayer.basic;

/**
 * Created by Maletskov on 28.02.2018.
 */
public class Track {
    private String name;
    private int time;
    private int year;
    private String singer;
    private String genre;

    public Track(String name, String singer, int time, int year, String genre) {
        this.name = name;
        this.singer = singer;
        this.time = time;
        this.year = year;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public int getTime() {
        return time;
    }

    public int getYear() {
        return year;
    }

    public String getSinger() {
        return singer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (year != track.year) return false;
        if (name != null ? !name.equals(track.name) : track.name != null) return false;
        if (singer != null ? !singer.equals(track.singer) : track.singer != null) return false;
        return genre != null ? genre.equals(track.genre) : track.genre == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + time;
        result = 31 * result + year;
        result = 31 * result + (singer != null ? singer.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        String s = name + " - " + singer + " - " +
                (time / 60) + ":" + (time % 60 < 10 ? "0" : "") +
                (time % 60) + " - " + year + " - " + genre;
        return s;
    }
}
