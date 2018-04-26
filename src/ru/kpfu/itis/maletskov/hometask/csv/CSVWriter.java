package ru.kpfu.itis.maletskov.hometask.csv;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maletskov on 16.04.2018.
 */
public class CSVWriter {
    private File output;
    private String delimiter;

    public CSVWriter() {
        delimiter = ",";
    }

    public CSVWriter(String delimiter) {
        this.delimiter = delimiter;
    }

    public <T> void write2dArray(T[][] array) {
        output = new File("C:\\Users\\User\\IdeaProjects\\hometask\\src\\ru\\kpfu\\itis\\maletskov\\hometask\\csv\\output.csv");
        try (DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(output)))) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    if (j == array[0].length - 1) {
                        dos.writeUTF("" + array[i][j]);
                    } else {
                        dos.writeUTF(array[i][j] + delimiter);
                    }
                }
                dos.writeUTF("\n");
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public <T> void writeArray(T[] array1) {
        String[] array = new String[array1.length];
        for (int i = 0; i < array1.length; i++) {
            array[i] = array1[i].toString();
        }
        Pattern p = Pattern.compile(".+(;|,|\n).+");
        Pattern p1 = Pattern.compile(".+\".+");
        Matcher m;
        for (int i = 0; i < array.length; i++){
            m = p1.matcher(array[i]);
            if (m.find()){
                array[i] = array[i].replaceAll("\"", "\"\"");
            }
            m = p.matcher(array[i]);
            if (m.find()){
                array[i] = "\"".concat(array[i]).concat("\"");
            }
        }
        output = new File("output2.csv");
        String str = "";
        int size = array.length;
        int sqrt1 = Math.sqrt(size) > Math.round(Math.sqrt(size)) ? (int) Math.sqrt(size) : (int) Math.sqrt(size) + 1;
        try (FileWriter dos = new FileWriter(output)) {
            for (int i = 0; i < array.length;) {
                for (int j = 0; j < sqrt1; j++) {
                    if (i < array.length) {
                        if(j==sqrt1-1||i==array.length-1){
                            dos.write(array[i]+"\n");
                        }else{
                            dos.write(array[i]+" "+delimiter);
                        }
                        i++;
                    }else{
                        break;
                    }
                }
                System.out.println(str);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void writeFile(File file) {
        try {
            int size = 0;
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                size++;
                sc.next();
            }
            Scanner sc1 = new Scanner(file);
            Object[] array = new Object[size];
            for (int i = 0; i < size; i++) {
                array[i] = sc1.next();
            }
            this.writeArray(array);
        } catch (FileNotFoundException ex) {
           ex.printStackTrace();
        }
    }
}
