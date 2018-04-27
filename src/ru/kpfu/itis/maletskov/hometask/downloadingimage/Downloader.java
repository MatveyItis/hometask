package ru.kpfu.itis.maletskov.hometask.downloadingimage;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by Maletskov on 24.04.2018.
 */
public class Downloader {
    public static void main(String[] args) throws URISyntaxException {
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

        URI uri = new URI("https://openlibrary.org/api/books?bibkeys=ISBN:0451526538&format=json&jscmd=data");
        try (BufferedReader in = new BufferedReader(new InputStreamReader(uri.toURL().openConnection().getInputStream()))) {

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
