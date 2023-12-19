package org.example.sem5.homework;


import java.util.Random;
import java.util.concurrent.CountDownLatch;


public class Runner {
    private Philosopher[] philosophers;
    private CountDownLatch countDownLatch;
    private Random random = new Random();
    private StringBuilder result = new StringBuilder();
    private int counter = 1;


    public Runner(Philosopher[] philosophers, CountDownLatch countDownLatch) {
        this.philosophers = philosophers;
        this.countDownLatch = countDownLatch;
    }

    private void addPhilosopherInResults(Philosopher philosopher) {
        result.append((counter++) + ". " + philosopher.toString());
    }

    public synchronized void eat() {

        int chance = random.nextInt(5);
        if (!philosophers[chance].isFull() && philosophers[chance].getCounterEatTimes() < 3) {
            try {
                philosophers[chance].eat();
                philosophers[chance].setFull(true);
                addPhilosopherInResults(philosophers[chance]);
                philosophers[chance].setCounterEatTimes(philosophers[chance].getCounterEatTimes() + 1);
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void think() {

        int chance = random.nextInt(5);
        if (philosophers[chance].isFull()) {
            try {
                philosophers[chance].think();
                philosophers[chance].setFull(false);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public StringBuilder getResult() {
        return result;
    }
}