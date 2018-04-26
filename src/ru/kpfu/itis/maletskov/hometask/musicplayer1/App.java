package ru.kpfu.itis.maletskov.hometask.musicplayer1;

import com.mpatric.mp3agic.*;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.basic.MusicPlayer;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.basic.Playlist;
import ru.kpfu.itis.maletskov.hometask.musicplayer1.utils.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Maletskov on 04.03.2018.
 */
public class App extends Application{
    public final static String PATH = "src/ru/kpfu/itis/maletskov/hometask/musicplayer1/music/";
    public static boolean isPlayed = false;
    private ConsolUserInteractor terminal;
    private MemoryDataBase db;
    private MusicPlayer player;


    public App(String[] args) {
        super(args);
    }

    public static void main(String[] args) {
        App app = new App(args);
    }

    @Override
    public void init() {
        this.terminal = new ConsolUserInteractor();
        this.db = MemoryDataBase.getDb();
        this.player = new MusicPlayer();
    }

    @Override
    public void start() {
        try {
            this.terminal.print(Info.getStartInfo());
            String command;
            String lastSong = null;
            while ((command = this.terminal.readCommand()) != null) {
                switch (command) {
                    case "addSong":
                        if ((command = this.terminal.readCommand()) != null) {
                            lastSong = command;
                            this.db.save(command);
                        }
                        break;
                    case "sortLibraryByArtist":
                        this.db.sortByArtist();
                        this.terminal.print("<< Library is successfully sorted!" + "\n" +
                                "<< Enter the command 'getAllSongs' if you want to see the list of tracks");
                        break;
                    case "sortLibraryByName":
                        this.db.sortByName();
                        this.terminal.print("<< Library is successfully sorted!" + "\n" +
                                "<< Enter the command 'getAllSongs' if you want to see the list of tracks");
                        break;
                    case "getAllSongs":
                        this.terminal.print(this.db.getAllSongs());
                        break;
                    case "getAllSongsOfArtist":
                        this.terminal.print("Read the Artist's name: ");
                        try{
                            this.terminal.print(this.db.getAllSongsOfArtist(this.terminal.readCommand()) + "");
                        } catch (Exception e) {
                            this.terminal.print("Read the right name of the Artist!");
                        }
                        break;
                    case "play":
                        //if ((command = this.terminal.readCommand()) != null) {
                            if (db.contains(lastSong)) {
                                player.setCurrentName(lastSong);
                                isPlayed = true;
                                player.start();
                            } else {
                                this.terminal.print("Wrong name of song!");
                            }
                        //}
                        break;
                    case "countOfTracks":
                        this.terminal.print(this.db.count() + "");
                        break;
                    case "getAverageTime":
                        this.terminal.print("Read the Artist's name: ");
                        try{
                            this.terminal.print(this.db.getAverageTime(this.terminal.readCommand()) + "");
                        } catch (Exception e) {
                            this.terminal.print("Read the right name of the Artist!");
                        }
                        break;
                    case "stop":
                        isPlayed = false;
                        //player.stopPlaying();
                        break;
                    case "help":
                        this.terminal.print(Info.getHelpInfo());
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        this.terminal.print("Unknown command");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please enter the right name of song!");
        } catch (Exception e) {
            System.out.println("Can't read user input due error:");
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }
}