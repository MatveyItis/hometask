package ru.kpfu.itis.maletskov.hometask.filemanager;

import java.io.IOException;

/**
 * Created by Maletskov on 29.03.2018.
 */
public class App extends Application {
    private UserInteractor terminal;
    private FileManager manager;

    public static void main(String[] args) throws IOException {
        App app = new App(args);
    }

    public App(String[] args) throws IOException {
        super(args);
    }

    @Override
    public void init() throws IOException {
        this.terminal = new ConsolUserInteractor();
        this.manager = new FileManager("C:/Users/User");
        this.manager.printDirectories();
    }

    @Override
    public void start() throws IOException {
        String command;
        while ((command = this.terminal.readCommand()) != null) {
            switch (command) {
                case "help":
                    this.terminal.print(this.terminal.getHelp());
                    break;
                case "back":
                case "..":
                    this.manager.goUp();
                    this.manager.printDirectories();
                    break;
                case "get dn":
                    this.manager.printDirectories();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    if (this.manager.hasFile(command)) {
                        this.manager.goDown(command);
                        this.manager.printDirectories();
                    } else if (this.manager.isAbsolutePath(command)) {
                        this.manager.goDown(command);
                        this.manager.printDirectories();
                    } else {
                        this.terminal.print("Unknown command or unknown file name!");
                    }
                    break;
            }
        }
    }
}
