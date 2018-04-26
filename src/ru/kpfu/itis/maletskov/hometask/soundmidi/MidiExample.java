package ru.kpfu.itis.maletskov.hometask.soundmidi;

import javax.sound.midi.MidiUnavailableException;

/**
 * Created by Maletskov on 17.04.2018.
 */
public class MidiExample {

    public static void main(String[] args) throws MidiUnavailableException {
        Player player = new Player();
        player.close();
    }
}
