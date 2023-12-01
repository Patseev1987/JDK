package org.example.sem2.homework.task2;

import java.net.Socket;

public class Client implements SocketThreadListener {

    @Override
    public void onSocketStart(Socket s) {
        System.out.println("Started");
    }

    @Override
    public void onSocketStop() {
        System.out.println("Stopped");
    }

    @Override
    public void onSocketReady(Socket s) {
        System.out.println("Ready");
    }

    @Override
    public void onSocketException(Throwable e) {
        e.printStackTrace();
    }
}
