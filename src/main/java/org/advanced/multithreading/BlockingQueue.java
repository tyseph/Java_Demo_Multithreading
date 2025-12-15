package org.advanced.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private Queue<Integer> q;
    private final int capacity;

    public BlockingQueue(int capacity) {
        q = new LinkedList<>();
        this.capacity = capacity;
    }

    public boolean add(int item) {
        synchronized (q) {
            while (q.size() == capacity) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            q.add(item);
            q.notifyAll();
            return true;
        }
    }

    public int remove() {
        synchronized (q) {
            while (q.isEmpty()) {
                try {
                    q.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int element = q.poll();
            q.notifyAll();
            return element;
        }
    }
}
