package com.lwx.util;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
    private Thread t;
    private int port;
    private ServerSocket ss;

    public Server(int port) {
        try {
            this.port = port;
            ss = new ServerSocket(this.port);
            t = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Server开始监听");
            while (true) {
                Socket s = ss.accept();
                CommunicateDataNode cd = new CommunicateDataNode(s);
                cd.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, "ServerLisener");
            t.start();
        }
    }

}
