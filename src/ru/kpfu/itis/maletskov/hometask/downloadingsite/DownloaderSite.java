package ru.kpfu.itis.maletskov.hometask.downloadingsite;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloaderSite {
   public static int countOfDownload = 0;
   public static String baseUri = "http://fermaeda.ru/";

   public static void main(String[] args) throws URISyntaxException, IOException {
      String site = "http://fermaeda.ru/";
      download(site, 0);
      String[] arr = getAllHref(new URI(site));
      for (String s : arr) {
         download(s, 0);
      }
   }

   public static String[] getAllHref(URI uri) {
      try {
         Document doc = Jsoup.connect(String.valueOf(uri.toURL())).get();
         Element body = doc.body();
         String name = doc.title();

         Elements urls = body.getElementsByTag("a");
         List<String> arr = new ArrayList<>();
         for(Element url : urls) {
            //... и вытаскиваем их название...
            if (!url.attr("href").isEmpty()) {
               arr.add(url.attr("href"));
            }
         }
         String[] array = new String[arr.size()];
         for (int i = 0; i < arr.size(); i++) {
            array[i] = getUri(arr.get(i));
         }
         return array;
      } catch (IOException e) {}
      return null;
   }

   public static void download(String name, int n) throws IOException, URISyntaxException {
      if (name == null) {
         return;
      }
      URI uri = new URI(name);
      if (countOfDownload == 0) {
         name = "site";
      } else {
         name = "page" + countOfDownload;
      }
      File file = new File("/Users/matveymaletskov/" +
              "IdeaProjects/oldwindows/src/ru/kpfu/itis/maletskov/hometask/downloadingsite/" + name + ".html");
      if (file.exists()) {
         file.createNewFile();
      }
      if (uri.isAbsolute()) {
         try (Scanner sc = new Scanner(uri.toURL().openConnection().getInputStream());
              FileWriter out = new FileWriter(file)) {
            String line = "";
            while (sc.hasNextLine()) {
               line = sc.nextLine();
               out.write(line + "\n");
            }
            countOfDownload++;
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
      Pattern pattern = Pattern.compile("tel:[0-9]*");
      Matcher m = pattern.matcher(line);
      if (m.matches()) {
         return null;
      }
      if (line.charAt(0) == '#') {
         return null;
      }
      if (line.charAt(0) == '/' || !(line.charAt(0) == 'h'
       && line.charAt(1) == 't' && line.charAt(2) == 't'
       && line.charAt(3) == 'p')) {
         return baseUri + line;
      } else {
         return line;
      }
   }
}
