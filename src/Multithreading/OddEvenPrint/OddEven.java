package Multithreading.OddEvenPrint;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class OddEven {

    private static Object lock = new Object();

    // Write a method that will execute print
    // have a method to call this print based on cond
    // Main method using completable future to call
    static IntPredicate oddCond = o -> o%2 != 0;
    static IntPredicate evenCond = o -> o%2 == 0;


    public static void main(String[] args) throws InterruptedException {
        Executor executor = Executors.newFixedThreadPool(2);
        CompletableFuture.runAsync(() -> OddEven.printResult(oddCond));
        CompletableFuture.runAsync(() -> OddEven.printResult(evenCond));
        Thread.sleep(1000);

    }

    private static void printResult(IntPredicate cond) {
        IntStream.range(1,10)
                .filter(cond)
                .forEach(OddEven::execute);
    }
    private static void execute (int i) {
        synchronized (lock) {
            try {
                System.out.println("Thread Name is:" + Thread.currentThread().getName() + ":" + i);
                lock.notify();
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
