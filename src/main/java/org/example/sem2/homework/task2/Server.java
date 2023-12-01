package org.example.sem2.homework.task2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server implements ServerSocketThreadListener, SocketThreadListener {
    @Override
    public void onServerStart() {
        System.out.println("Server thread is started");
    }

    @Override
    public void onServerStop() {
        System.out.println("Server thread is stopped");
    }

    @Override
    public void onServerCreated(ServerSocket s) {
        System.out.println("Server socket was created");
    }

    @Override
    public void onServerSoTimeout(ServerSocket s) {
        System.out.println("Accept time");
    }

    @Override
    public void onSocketAccepted(ServerSocket s, Socket client) {
        System.out.println("Client connected");
    }

    @Override
    public void onServerException(Throwable e) {
        e.printStackTrace();
    }

    @Override
    public void onSocketStart(Socket s) {
        System.out.println("Client connected");
    }

    @Override
    public void onSocketStop() {
        System.out.println("Client dropped");
    }

    @Override
    public void onSocketReady(Socket s) {
        System.out.println("Client is ready");
    }

    @Override
    public void onSocketException(Throwable e) {
        e.printStackTrace();
    }
}
