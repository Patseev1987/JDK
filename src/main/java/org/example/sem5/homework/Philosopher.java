package org.example.sem5.homework;

import java.util.Random;

public class Philosopher {
    private String name;
    private int id;
    private boolean isFull;
    private int counterEatTimes;

    public int getCounterEatTimes() {
        return counterEatTimes;
    }

    public void setCounterEatTimes(int counterEatTimes) {
        this.counterEatTimes = counterEatTimes;
    }

    public Philosopher(String name, int id) {
        this.name = name;
        this.id = id;
        isFull = false;
    }

    public boolean isFull() {
        return isFull;
    }

    public void setFull(boolean full) {
        isFull = full;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void eat() throws InterruptedException {
        System.out.println(String.format("Philosopher %s with id %d has started eating!", name, id));
        Thread.sleep(500);
        System.out.println(String.format("Philosopher %s with id %d has finished eat!",name, id));
    }


    public void think() throws InterruptedException {

        System.out.println(String.format("Philosopher %s with id %d has started thinking!", name, id));
        Thread.sleep(new Random().nextLong(500,1500));
        System.out.println(String.format("Philosopher %s with id %d has finished think!",name, id));
    }


    @Override
    public String toString() {
        return String.format("Philosopher %s with id %d.\n", name, id);
    }
}
