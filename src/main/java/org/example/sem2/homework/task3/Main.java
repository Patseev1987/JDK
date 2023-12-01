package org.example.sem2.homework.task3;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FullstackDeveloper fullstackDeveloper = new FullstackDeveloper();
        fullstackDeveloper.developGUI();
        fullstackDeveloper.developServer();
        Developer developer = new FullstackDeveloper();

        //Homework
        if (developer instanceof Frontender){
            ((Frontender) developer).developGUI();
        }
    }
}
