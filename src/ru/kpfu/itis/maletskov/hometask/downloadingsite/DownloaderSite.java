package ru.kpfu.itis.maletskov.hometask.downloadingsite;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloaderSite {
   public static int countOfDownload = 0;
   public static String baseUri = "http://fermaeda.ru/";

   public static void main(String[] args) throws URISyntaxException, IOException {
      URI uri = new URI("http://fermaeda.ru/");
      //System.out.println(getLines());
      download(uri);
      String[] arr = getAllHref(uri);
      for (String s : arr) {
         download(new URI(s));
      }
   }

   public static String[] getAllHref(URI uri) {
      try (Scanner sc = new Scanner(new File("/Users/matveymaletskov/" +
              "IdeaProjects/oldwindows/src/ru/kpfu/itis/maletskov/hometask/downloadingsite/site.html"))) {
         String s = sc.nextLine();
         Pattern p = Pattern.compile("(href=\")[A-Za-z:.*\\/]+");
         Matcher m = p.matcher(s);
         StringBuilder sb = new StringBuilder();
         while (m.find()) {
            sb.append(getUri(m.group())).append(";;");
         }
         String[] arr = sb.toString().split(";;");
         sc.close();
         return arr;
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      }
      return null;
   }

   public static boolean hasHref(String line) {
      Pattern p = Pattern.compile("(href=\")[A-Za-z:.*\\/]+");
      Matcher m = p.matcher(line);
      return m.matches();
   }

   public static void download(URI uri) throws IOException {
      String name;
      if (countOfDownload == 0) {
         name = "site";
      } else {
         name = "page" + countOfDownload;
      }
      if (uri.isAbsolute()) {
         try (Scanner sc = new Scanner(uri.toURL().openConnection().getInputStream());
              FileWriter out = new FileWriter(new File("/Users/matveymaletskov/" +
                      "IdeaProjects/oldwindows/src/ru/kpfu/itis/maletskov/hometask/downloadingsite/" + name + ".html"))) {
            String line = "";
            while (sc.hasNextLine()) {
               line = sc.nextLine();
               out.write(line + "\n");
            }
            sc.close();
            out.close();
         } catch (MalformedURLException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }

   public static String getUri(String line) {
      if (!hasHref(line)) {
         return null;
      }
      Pattern p = Pattern.compile("(href=\")[A-Za-z:.*\\/]+");
      Matcher m = p.matcher(line);
      String str = "";
      while (m.find()) {
         str = m.group();
      }
      String[] arr = str.split("=\"");
      if (arr[1].charAt(0) != 'h') {
         return baseUri + arr[1];
      } else {
         return arr[1];
      }
   }
}
