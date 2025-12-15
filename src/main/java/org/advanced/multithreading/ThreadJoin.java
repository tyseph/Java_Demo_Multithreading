package org.advanced.multithreading;

public class ThreadJoin {

    public static void main(String[] args) {
        System.out.println("Main Starting");
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread());
        }, "Join Thread");

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main Exiting");

    }
}
