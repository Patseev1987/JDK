package org.example.sem5.homework;

import java.util.Random;
import java.util.concurrent.CountDownLatch;


public class Test1 {
    private static final StringBuilder RESULTS = new StringBuilder();
    private static  int counter = 1;
    private static void addPhilosopherInResults(Philosopher philosopher) {
        RESULTS.append((counter++)+". " +philosopher.toString());
    }

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher("John", 1);
        philosophers[1] = new Philosopher("Alice", 2);
        philosophers[2] = new Philosopher("Tom", 3);
        philosophers[3] = new Philosopher("Bob", 4);
        philosophers[4] = new Philosopher("Donald", 5);
        CountDownLatch countDownLatch = new CountDownLatch(15);

        Thread thread1 = new Thread(() -> {
            while (countDownLatch.getCount() > 0) {
                int chance = random.nextInt(5);
                if (!philosophers[chance].isFull() && philosophers[chance].getCounterEatTimes()<3) {
                    try {
                        philosophers[chance].eat();
                        addPhilosopherInResults(philosophers[chance]);
                        philosophers[chance].setFull(true);
                        philosophers[chance].setCounterEatTimes(philosophers[chance].getCounterEatTimes()+1);
                        countDownLatch.countDown();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            while (countDownLatch.getCount() > 0) {
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
        });
thread1.start();
thread2.start();
thread2.join();
        System.out.println("All philosophers ate 3 times and thought after meals!");
        System.out.println("Results :");
        System.out.println(RESULTS.toString());
    }
}
