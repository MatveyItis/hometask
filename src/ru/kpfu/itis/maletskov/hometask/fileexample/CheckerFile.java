package ru.kpfu.itis.maletskov.hometask.fileexample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Maletskov on 29.03.2018.
 */
public class CheckerFile {
    private String name;
    private Path path;
    private File file;

    public CheckerFile(String name) {
        this.name = name;
        path = Paths.get(name);
        file = new File(this.path.toUri());
    }

    public void checkDirectory() throws IOException {
        if (this.file.isDirectory()) {
            File[] f = this.file.listFiles();
            for (int i = 0; i < f.length; i++) {
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(f[i].lastModified());

                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

                System.out.println("<<Name of directory : "+f[i].getName() + ">>\t" + "<<Last using: " + format.format(cal.getTime()) + ">>");
            }
        } else {
            this.file.exists();
        }
    }

    public String getName() {
        return name;
    }
}
