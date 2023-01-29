package com.lwx.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CommunicateDataNode implements Runnable {

    private Thread t;
    private Socket socket;
    private String DName;

    public CommunicateDataNode(Socket socket) {
        this.socket = socket;
        t = null;
        try {
            DName = socket.getInetAddress().getLocalHost().toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String mess;
            while (true) {
                mess = br.readLine();
                System.out.println(DName + ": " + mess);
                bw.write(mess + "\n");
                bw.flush();
                if (mess.equals("quit"))
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            System.out.println("DataNode: " + DName + "连接到主机");
            if (t == null) {
                t = new Thread(this, DName);
                t.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
