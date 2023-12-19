package org.example.sem5.task3;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    private static volatile int amountFinishedCar = 3;

    public static int getAmountFinishedCar() {
        return amountFinishedCar;
    }

    public static void setAmountFinishedCar(int amountFinishedCar) {
        Task3.amountFinishedCar = amountFinishedCar;
    }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
        executorService.submit(new Car(countDownLatch, i+1));
        }
        executorService.shutdown();
        System.out.println("Three!");
        Thread.sleep(1000);
        System.out.println("Two!");
        Thread.sleep(1000);
        System.out.println("One!");
        Thread.sleep(1000);
        System.out.println("GO!");
        countDownLatch.await();
        System.out.println("Race started!");

        while (true){
            if(amountFinishedCar==0){
                System.out.println("Race is over");
                break;
            }
        }
    }
}
