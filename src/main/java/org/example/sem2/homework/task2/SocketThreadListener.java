package org.example.sem2.homework.task2;

import java.net.Socket;

public interface SocketThreadListener {
    void onSocketStart(Socket s);
    void onSocketStop();
    void onSocketReady(Socket s);
    void    onSocketException(Throwable e);
}
