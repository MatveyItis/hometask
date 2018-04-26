package ru.kpfu.itis.maletskov.hometask.musicplayer1.comparators;

import ru.kpfu.itis.maletskov.hometask.musicplayer1.basic.Track;

import java.util.Comparator;

/**
 * Created by Maletskov on 05.03.2018.
 */
public class ArtistComparator implements Comparator<Track> {
    @Override
    public int compare(Track o1, Track o2) {
        return o1.getArtist().compareTo(o2.getArtist());
    }
}
