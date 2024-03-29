package Multithreading.ProducerConsumerProblem;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> queue;
    private int size;

    public SharedResource(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while(queue.size() == size) {
            System.out.println("Queue is full, Producer is waiting");
            wait();
        }
        queue.add(item);
        System.out.println("Item produces: " + item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (queue.isEmpty()) {
            System.out.println("Consumer waiting for item to be produced");
            wait();
        }
        int item = queue.poll();
        System.out.println("Item consumed");
        notify();
        return item;
    }


}
