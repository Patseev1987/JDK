package org.example.sem2.homework.task2;

import java.net.ServerSocket;
import java.net.Socket;

public interface ServerSocketThreadListener {
    void onServerStart();
    void onServerStop();
    void onServerCreated(ServerSocket s);
    void onServerSoTimeout(ServerSocket s);
    void onSocketAccepted(ServerSocket s, Socket client);
    void  onServerException(Throwable e);
}
