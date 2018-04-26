package ru.kpfu.itis.maletskov.hometask.controlsystemdb;

import ru.kpfu.itis.maletskov.hometask.controlsystemdb.db.DbException;
import ru.kpfu.itis.maletskov.hometask.controlsystemdb.db.StudentsDataBase;
import ru.kpfu.itis.maletskov.hometask.controlsystemdb.utils.ConsolUserInteractor;
import ru.kpfu.itis.maletskov.hometask.controlsystemdb.utils.UserInteractor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;

/**
 * Created by Maletskov on 01.04.2018.
 */
public class App extends Application{
    private StudentsDataBase db;
    private UserInteractor terminal;
    public final static String DB_PATH = "C:/Users/User/IdeaProjects/hometask/src/ru/kpfu/itis/maletskov/hometask/controlsystemdb/db/students.ser";

    App(String[] msg) throws DbException, IOException {
        super(msg);
    }

    public static void main(String[] args) throws DbException, IOException {
        App app = new App(args);
    }

    @Override
    public void init() {
        this.db = new StudentsDataBase(DB_PATH);
        this.terminal = new ConsolUserInteractor();
    }

    @Override
    public void start() throws DbException, IOException {
        String command;
        try {
            while ((command = this.terminal.readCommand()) != null) {
                switch (command) {
                    case "print":
                        this.db.printAll();
                        break;
                    case "add":
                        this.terminal.print("Read name of the student then read age of student \n" +
                                "and then read \"1\" if student is man or \"0\" if student is woman");
                        this.db.save(new Student(terminal.readCommand(), terminal.readInt(), terminal.readInt()));
                        this.terminal.print("Student is added!");
                        break;
                    case "exit":
                        System.exit(0);
                        break;
                    default:
                        this.terminal.print("Unknown command");
                        break;
                }
            }
        } catch (DbException e) {
            System.out.println("DB error: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("You are entered wrong type! Read Integer, please!");
            throw e;
        }
    }
}
