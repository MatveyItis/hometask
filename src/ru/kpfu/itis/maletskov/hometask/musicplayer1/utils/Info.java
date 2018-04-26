package ru.kpfu.itis.maletskov.hometask.musicplayer1.utils;

/**
 * Created by Maletskov on 04.03.2018.
 */
public class Info {

    public static String getStartInfo() {
        return "Welcome to my App!" + "\n" +
                "<< If you want to add a song into " + "\n" +
                "<< your playlist, you should enter " + "\n" +
                "<< information like 'the artist - the song's name'" + "\n" +
                "<< All songs are taken from common library and " + "\n" +
                "<< if the entering song doesn't contained " + "\n" +
                "<< in our list, program report it to you";
    }

    public static String getHelpInfo() {
        return  "<< Available commands:" + "\n" +
                "<< 1 - addSong : add song to your library." + "\n" +
                "<<     If you want to add a song into your library, you should" + "\n" +
                "<<     enter information like 'the artist-the song's name'." + "\n" +
                "<< 2 - getAllSongs : print all tracks containing in your library." + "\n" +
                "<< 3 - play : program will play the last song, containing in your library." + "\n" +
                "<< 4 - stop : playing music will be switch off." + "\n" +
                "<< 5 - sortLibraryByArtist : sorting playlist by artist." + "\n" +
                "<< 6 - sortLibraryByName : sorting playlist by name." + "\n" +
                "<< 7 - exit : exit from program.";
    }
}
