package ru.kpfu.itis.maletskov.hometask.notebook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;

/**
 * Created by Maletskov on 14.04.2018.
 */
public class App extends Application{
    private static final String path = "C:\\Users\\User\\IdeaProjects\\hometask\\src\\ru\\kpfu\\itis\\maletskov\\hometask\\notebook\\notebook.txt";
    private Notebook nb;
    private UserInteractor terminal;

    public App(String[] args) throws IOException {
        super(args);
    }

    public static void main(String[] args) throws IOException {
        App app = new App(args);
    }

    @Override
    public void init() throws IOException {
        this.nb = new Notebook(App.path);
        this.terminal = new ConsolUserInteractor();
    }

    @Override
    public void start() throws IOException {
        this.terminal.print(this.terminal.getHelp());
        String command;
        try {
            while ((command = this.terminal.readCommand()) != null) {
                switch (command) {
                    case "help":
                        this.terminal.print(this.terminal.getHelp());
                        break;
                    case "add":
                        this.nb.addNote(this.terminal.readCommand());
                        break;
                    case "read":
                        this.terminal.print("Read number of note:");
                        this.terminal.print(this.nb.readNote(Integer.parseInt(this.terminal.readCommand())));
                        break;
                    case "readAll":
                        this.terminal.print(this.nb.readAllNotes());
                        break;
                    case "exit":
                        System.exit(0);
                    default:
                        this.terminal.print("Unknown command");
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Number format error! Please enter number");
        } catch (NoSuchElementException e) {
            System.err.println("This number of note is not exist!\n" +
                    "Enter please number between 0 and " + this.nb.getLinesCount());
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
    }
}
