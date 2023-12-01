package org.example.sem2.homework.task1;

public class ChatServer {
    private boolean isServerWorking;
    private ServerListener serverListener;

    public ChatServer(ServerListener serverListener) {
        this.serverListener = serverListener;
        isServerWorking = false;
    }

    public void start(){
        if (isServerWorking){
            serverListener.getMessage("Server is already working!");
            return;
        }
        serverListener.getMessage("Server started");
        isServerWorking = true;
    }

    public void stop(){
        if(!isServerWorking){
            serverListener.getMessage("Server is stopped");
            return;
        }
        serverListener.getMessage("Server stopped");
        isServerWorking = false;
    }
}
