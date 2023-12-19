package org.example.sem5.task3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Car implements Runnable{
    private final Random  random = new Random();
    private final CountDownLatch countDownLatch;

    private int id;

    public Car(CountDownLatch countDownLatch, int id) {
        this.countDownLatch = countDownLatch;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(random.nextLong(700,2500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        countDownLatch.countDown();
        System.out.println("Car with id "+id+" is ready for start!");
        try {
            Thread.sleep(random.nextLong(1700,4500));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Car with id "+id+" finished!");
        finish();
    }

    public void finish(){
        Task3.setAmountFinishedCar(Task3.getAmountFinishedCar()-1);
    }

}
