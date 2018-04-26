package ru.kpfu.itis.maletskov.hometask.aisd;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.AdvancedPlayer;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.App;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Maletskov on 12.02.2018.
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException, JavaLayerException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        AdvancedPlayer player = new AdvancedPlayer(new FileInputStream(App.PATH + sc.nextLine() + ".mp3"));
        player.play();
        Thread.sleep(1500);
        player.stop();
    }
}
