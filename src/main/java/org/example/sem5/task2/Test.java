package org.example.sem5.task2;

public class Test {
    private static volatile boolean switcher = true;

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                changeSwitcher();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            }

        });


        Thread thread2 = new Thread(() -> {

            while (!switcher) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            for (int i = 100; i >= 0; i--) {
                try {
                    System.out.println(i);
                    Thread.sleep(100);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


        });
        thread1.start();
        thread2.start();
    }

    private static void changeSwitcher() {
        switcher = !switcher;
        System.out.println("switcher was changed!!! new value: " + switcher);
    }
}
