package org.example.sem5.task1;

public class Task1 {

       final ObjectA objectA = new ObjectA();
        final ObjectB objectB = new ObjectB();


        public void firstMethod() throws InterruptedException {
            synchronized (objectA){
                synchronized (objectB){
                    System.out.println(objectA.getInfo());
                    Thread.sleep(100);
                }
            }
        }
    public void secondMethod() throws InterruptedException {
        synchronized (objectB){
            synchronized (objectA){
                System.out.println(objectB.getInfo());
                Thread.sleep(100);
            }
        }
    }


    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {

                try {
                    task1.firstMethod();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    task1.secondMethod();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        });

        thread1.start();
        thread2.start();
    }
}
