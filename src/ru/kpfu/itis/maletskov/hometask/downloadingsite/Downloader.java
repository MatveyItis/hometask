package ru.kpfu.itis.maletskov.hometask.downloadingsite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Maletskov on 24.04.2018.
 */
public class Downloader {
    public static void main(String[] args) {
        /*//download image
        URI uri = new URI("https://openlibrary.org/static/images/openlibrary-logo.png");
        try (InputStream in = uri.toURL().openConnection().getInputStream();
            OutputStream out = new FileOutputStream(new File("image.png"))) {
            int b;
            while (in.available() > 0) {
                b = in.read();
                System.out.println(b);
                out.write(b);
            }
            out.close();
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("Read ISBN-number of the book please: ");
        String isbn = sc.nextLine();
        try {
            URI uri = new URI("https://openlibrary.org/api/books?bibkeys=ISBN:" + isbn + "&format=json&jscmd=data");
            try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream())))) {
                String s = in.nextLine();
                if (s.equals("{}")) {
                    System.err.println("Read right ISBN-number of the book!");
                    System.exit(0);
                }
                Pattern p = Pattern.compile("(\"title\": )([\"A-Za-z \"]+)");
                Matcher m = p.matcher(s);
                String str = "";
                while (m.find()) {
                    str = m.group();
                }
                System.out.println(str.split(": ")[1]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (URISyntaxException e) {
            System.err.println("Read right ISBN-number of the book!");
        }
    }
}
