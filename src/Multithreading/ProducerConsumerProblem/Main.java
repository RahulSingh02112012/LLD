package Multithreading.ProducerConsumerProblem;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);

        Thread producerThread = new Thread(()-> {
            for (int i =0;i<=6;i++) {
                try {
                    sharedResource.produce(i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(()-> {
            for (int i =0;i<=6;i++) {
                try {
                    System.out.println(sharedResource.consume());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
       // System.out.println(Runtime.getRuntime().availableProcessors());

        producerThread.start();
        consumerThread.start();
    }
}
