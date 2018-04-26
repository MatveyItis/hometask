package ru.kpfu.itis.maletskov.hometask.musicplayer1.basic;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Maletskov on 04.03.2018.
 */
public class MusicPlayer extends Thread {
    private AdvancedPlayer pl;
    private String currentName;

    public MusicPlayer() {
    }

    public void play(String s) {
        try {
            pl = new AdvancedPlayer(new FileInputStream(App.PATH + s + ".mp3"));
            pl.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void stopPlaying() {
        pl.close();
    }

    @Override
    public void run() {
        play(currentName);
        while (true) {
            if (!App.isPlayed) {
                pl.stop();
            }
        }
    }

    public void setCurrentName(String currentName) {
        this.currentName = currentName;
    }

    /*public void stop() {
        pl.stop();
    }*/

}
