package org.advanced;

public class ThreadState {
    public static void main(String[] args) {
        Thread thread3 = new Thread(() -> {
            try {
                Thread.sleep(1);
                for (int i = 10000; i > 0; i--) ;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },
                "States");
        thread3.start();
        while (true) {
            Thread.State state = thread3.getState();
            System.out.println(state);
            if (state == Thread.State.TERMINATED) break;
        }
    }
}

