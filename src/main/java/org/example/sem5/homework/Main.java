package org.example.sem5.homework;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(15);
        Philosopher[] philosophers = new Philosopher[5];
        philosophers[0] = new Philosopher("John", 1);
        philosophers[1] = new Philosopher("Alice", 2);
        philosophers[2] = new Philosopher("Tom", 3);
        philosophers[3] = new Philosopher("Bob", 4);
        philosophers[4] = new Philosopher("Donald", 5);
        Runner runner = new Runner(philosophers,countDownLatch);
Thread thread1 = new Thread( () -> {
    while (countDownLatch.getCount()>0) {
        runner.eat();
    }
});
 Thread thread2 = new Thread( () -> {
     while (countDownLatch.getCount()>0) {
         runner.think();
     }
 });
 thread1.start();
 thread2.start();
 thread2.join();
        countDownLatch.await();
        System.out.println("The end!");
        System.out.println(runner.getResult());
    }
}
