package ru.kpfu.itis.maletskov.hometask.notebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Created by Maletskov on 14.04.2018.
 */
public class Notebook {
    private File file;
    private int count;
    private static Logger log = Logger.getLogger(Notebook.class.getName());

    public Notebook(String path) throws IOException {
        this.file = new File(path);
        this.count = this.getCount();
        log.info("Start program");
    }

    public void addNote(String note) {
        try(FileWriter fw = new FileWriter(file, true)) {
            fw.write(note + '\n');
            log.info("Note is added!");
            count = this.getCount();
            fw.close();
        } catch (IOException e) {
            log.warning("Error in addition of note");
        }
    }

    public String readNote(int n) throws IOException {
        log.info("reading note");
        String s = null;
        if (n <= 0 || n > count) {
            log.warning("the number of note is not exists");
            return null;
        }
        Scanner sc = new Scanner(file);
        for (int i = 1; i <= n; i++) {
            s = sc.nextLine();
        }
        sc.close();
        return s;
    }

    public String readAllNotes() throws FileNotFoundException {
        log.info("reading notes");
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(file);
            for (int i = 1; i < count; i++) {
                sb.append(i + ") ").append(sc.nextLine()).append("\n");
            }
            sb.append(count + ") ").append(sc.nextLine());
            sc.close();
            return sb.toString();
    }

    public int getLinesCount() {
        return getCount();
    }

    private int getCount() {
        count = 0;
        try(Scanner scanner = new Scanner(file)) {
            String s = null;
            while (scanner.hasNextLine()) {
                count++;
                s = scanner.nextLine();
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return count;
    }
}
