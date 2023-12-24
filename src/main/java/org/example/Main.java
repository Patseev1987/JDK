package org.example;


import org.example.sem6.ParadoxMonroGame;

public class Main {
    public static void main(String[] args) {
        ParadoxMonroGame paradoxMonroGame1 = new ParadoxMonroGame(1000,true);
        ParadoxMonroGame paradoxMonroGame2 = new ParadoxMonroGame(1000,false);
        paradoxMonroGame1.getInfo();
        paradoxMonroGame2.getInfo();


    }
}