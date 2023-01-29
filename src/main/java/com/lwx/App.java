package com.lwx;

import com.lwx.util.Server;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Server s = new Server(8085);
        s.start();
        System.out.println("check");
    }
}
