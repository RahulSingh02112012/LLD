package Multithreading;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample {
    public static void main(String[] args) {
        // Creating a CopyOnWriteArrayList
        List<String> copyOnWriteList = new CopyOnWriteArrayList<>();

        // Adding elements
        copyOnWriteList.add("Java");
        copyOnWriteList.add("Python");
        copyOnWriteList.add("C++");

        // Creating a thread for modification
        Thread modifyThread = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                copyOnWriteList.add("New Language " + i);
                try {
                    Thread.sleep(1000); // Simulating some delay between additions
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Creating a thread for reading
        Thread readThread = new Thread(() -> {
            for (String language : copyOnWriteList) {
                System.out.println("Language: " + language);
                try {
                    Thread.sleep(500); // Simulating some delay between reads
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Starting both threads
        modifyThread.start();
        readThread.start();
    }
}

