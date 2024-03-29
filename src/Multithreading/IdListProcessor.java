package Multithreading;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


       /* Java Multithreading question :
        Imaging you have a List of ids(Integer). Now, a thread is adding new ids in the background and your task is to find if a given id exists or not in the list, taking into account the thread that is regularly adding new values (return true or false).
        Given - The ids are added in increasing order only (not continuous), you can't put a lock on the List.*/
public class IdListProcessor {
    private final List<Integer> idList = new CopyOnWriteArrayList<>();

    public void addId(int id) {
        idList.add(id);
    }

    public boolean containsId(int targetId) {
        int index = binarySearch(idList, targetId);
        return index >= 0;
    }

    private int binarySearch(List<Integer> list, int target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = list.get(mid);

            if (midVal < target) {
                low = mid + 1;
            } else if (midVal > target) {
                high = mid - 1;
            } else {
                return mid; // key found
            }
        }
        return -(low + 1);  // key not found
    }

    public static void main(String[] args) {
        IdListProcessor idListProcessor = new IdListProcessor();

        // Simulate background thread adding ids
        Thread backgroundThread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                int newId = i * 2; // Just an example, you can replace this with actual logic
                idListProcessor.addId(newId);
                try {
                    Thread.sleep(1000); // Simulate some delay between additions
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        backgroundThread.start();

        // Simulate main thread checking if an id exists
        for (int i = 0; i < 10; i++) {
            int targetId = i * 2 + 1; // Just an example, you can replace this with actual logic
            boolean result = idListProcessor.containsId(targetId);
            System.out.println("Does id " + targetId + " exist? " + result);
            try {
                Thread.sleep(2000); // Simulate some delay between checks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
