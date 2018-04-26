package ru.kpfu.itis.maletskov.hometask.musicplayer;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import ru.kpfu.itis.maletskov.hometask.musicplayer.memory.MemoryDataBase;
import ru.kpfu.itis.maletskov.hometask.musicplayer.utils.ConsolUserInteractor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by Maletskov on 28.02.2018.
 */
public class App extends Application{
    protected MemoryDataBase db;
    protected ConsolUserInteractor terminal;

    public App(String[] args) {
        super(args);
    }

    public static void main(String[] args) {
        //App app = new App(args);
        try  {
            FileInputStream f = new FileInputStream("src/ru/kpfu/itis/maletskov/hometask/musicplayer/не от мира сего.mp3");
            Player p = new Player(f);


        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void init() {
        this.db = MemoryDataBase.getDb();
        this.terminal = ConsolUserInteractor.getTerminal();
    }

    @Override
    public void start() {

    }
}
