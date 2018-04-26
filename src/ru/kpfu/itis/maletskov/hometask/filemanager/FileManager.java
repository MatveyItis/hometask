package ru.kpfu.itis.maletskov.hometask.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Maletskov on 29.03.2018.
 */
public class FileManager {
    private File currentFile;
    private Path path;

    public FileManager(String way) throws IOException {
        path = Paths.get(way);
        currentFile = new File(path.toUri());
    }

    public void goUp() {
        this.setPath("/..");
        this.currentFile = Paths.get(String.valueOf(path)).toFile();
    }

    public void goDown(String name) {
        this.setPath(name);
        this.currentFile = Paths.get(String.valueOf(path)).toFile();
    }

    public File[] getAllDirectories() {
        if (hasDirectory()) {
            File[] f = currentFile.listFiles();
            return f;
        }
        return null;
    }

    public String[] getAllFileNames() {
        if (!hasDirectory()) {
            String[] s = currentFile.list();
            return s;
        }
        return null;
    }

    public boolean hasDirectory() {
        return currentFile.isDirectory();
    }

    public boolean hasFile(String name) {
        if (hasDirectory()) {
            File[] f = getAllDirectories();
            for (int i = 0; i < f.length; i++) {
                if (f[i].getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    public File getCurrentFile() {
        return currentFile;
    }

    public Path getPath() {
        return path;
    }

    public void printDirectories() {
        if (getAllDirectories() != null) {
            File[] f = this.getAllDirectories();
            for (int i = 0; i < f.length; i++) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(f[i].lastModified());

                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

                System.out.println((f[i].isDirectory() ? "<<Name of dir  : " : "<<Name of file : ") + "<<" + f[i].getName()
                        + ">>" + "     " + "<<Last using: " + format.format(cal.getTime()) + ">>");
            }
        } else {
            System.err.print("Entering path name does not exist.");
            System.exit(1);
        }
    }

    public boolean isAbsolutePath(String command) {
        Path p = Paths.get(command);
        return p.isAbsolute();
    }

    protected void setPath(String name) {
        //this.path = path.resolve(path);
        this.path = path.resolve(name);
        //this.path = Paths.get(this.path.toString() + "/" + name);
    }
}
