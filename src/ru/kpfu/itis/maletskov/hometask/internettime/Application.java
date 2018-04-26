package ru.kpfu.itis.maletskov.hometask.internettime;

import java.io.IOException;
import java.net.Socket;
/**
 * Created by Maletskov on 15.03.2018.
 */
public class Application {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 123);
        socket.setSoTimeout(5);
    }
}
