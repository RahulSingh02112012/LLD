package Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Main {
    public static void main(String[] args) {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(5);

        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        producerThread.start();
        consumerThread.start();
    }
}
class CustomBlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public CustomBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public void enqueue(T item) throws InterruptedException {
        lock.lock();
        try {
            while (queue.size() == capacity) {
                notFull.await();
            }

            queue.add(item);
            System.out.println("Enqueued: " + item);

            notEmpty.signal(); // Notify waiting consumers
        } finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()) {
                notEmpty.await();
            }

            T item = queue.poll();
            System.out.println("Dequeued: " + item);

            notFull.signal(); // Notify waiting producers

            return item;
        } finally {
            lock.unlock();
        }
    }
}

class Producer implements Runnable {
    private final CustomBlockingQueue<Integer> queue;

    public Producer(CustomBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.enqueue(i);
                Thread.sleep(500); // Simulating some work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements Runnable {
    private final CustomBlockingQueue<Integer> queue;

    public Consumer(CustomBlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer item = queue.dequeue();
                Thread.sleep(1000); // Simulating some work
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}


