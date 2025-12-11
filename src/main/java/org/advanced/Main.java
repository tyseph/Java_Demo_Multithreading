package org.advanced;

public class Main {
    public static void main(String[] args) {

        System.out.println("Starting Main Thread");

        Thread thread1 = new Thread1("T-1");
        thread1.start();

        Thread thread2 = new Thread(new Thread2(), "T-2");
        thread2.start();

        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 5; i++)
                i = 5;
//                System.out.println("Thread Name: " + Thread.currentThread().getName() + ": " + i);
        }, "T-3");
        thread3.start();

        Stack stack = new Stack(5);

        new Thread(() -> {
            int counter = 0;
            while (++ counter < 10)
                System.out.println("Pushed: " + stack.push(100));
        }, "Pusher").start();

        new Thread(() -> {
            int counter = 0;
            while (++ counter < 10)
                System.out.println("Popped： " + stack.pop());
        }, "Popper").start();

        System.out.println(thread1.getPriority());

        System.out.println("Stopping Main Thread");
    }
}