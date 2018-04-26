package ru.kpfu.itis.maletskov.hometask.musicplayer1.utils;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.basic.Playlist;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.basic.Track;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.comparators.ArtistComparator;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.comparators.NameComparator;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Maletskov on 04.03.2018.
 */
public class MemoryDataBase implements DataBase{
    //private List<Mp3File> db;
    //private Map<String, Mp3File> data;
    private List<Track> data1;//будем переделывать под лист, убирая этот ужасный код с мэп
    //мэп нужен для того, чтобы хранить название песни и исполнителя,
    //так как подключенной библиотекой нихера не работает
    //выкручиваемся как можем!

    private MemoryDataBase() {
        //data = new HashMap<>();
        data1 = new ArrayList<>();
    }

    private static class MemoryDataBaseHolder {
        private final static MemoryDataBase db = new MemoryDataBase();
    }

    public static MemoryDataBase getDb() {
        return MemoryDataBaseHolder.db;
    }

    @Override
    public void save(String s) throws FileNotFoundException {
        try {
            Track track = new Track(s);
            data1.add(track);
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

    public int count() {
        return (int) data1.stream().count();
    }

    //метод возвращает среднюю продолжительность треков,
    //введенего нами артиста
    public double getAverageTime(String name) {
        return data1.stream().filter((p) -> name.equals(p.getArtist())).mapToDouble(Track::getTime).average().getAsDouble();
    }

    public String getAllSongsOfArtist(String name) {
        return data1.stream().filter((p) -> name.equals(p.getArtist())).map(track -> track.getName()).collect(Collectors.joining(", "));
    }

    public void sortByName() {
        Collections.sort(data1, new NameComparator());
    }

    public void sortByArtist() {
        Collections.sort(data1, new ArtistComparator());
    }

    public String getAllSongs() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data1.size() - 1; i++) {
            sb.append(data1.get(i).toString());
        }
        sb.append(data1.get(data1.size() - 1).toString());
        return sb.toString();
    }

    public boolean contains(String s) {
        for (int i = 0; i < data1.size(); i++) {
            if ((data1.get(i).getTitle()).equals(s)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void savePlaylist(Playlist playlist) {

    }

    @Override
    public String[] findAll() {
        return new String[0];
    }

}
