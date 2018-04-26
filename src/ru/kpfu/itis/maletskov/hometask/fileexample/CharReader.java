package ru.kpfu.itis.maletskov.hometask.fileexample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Scanner;

/**
 * Created by Maletskov on 29.03.2018.
 */
public class CharReader {
    private char c;
    private Scanner sc;

    public CharReader() {
        sc = new Scanner(System.in);
        c = sc.next().charAt(0);
    }

    public void writeChar() {
        try(FileOutputStream is = new FileOutputStream("C:/Users/User/IdeaProjects" +
                "/hometask/src/ru/kpfu/itis/maletskov/hometask/fileexample/asserts/file1.txt")) {
            byte[] data = ByteBuffer.allocate(2).putChar(this.c).array();
            is.write(data);
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
