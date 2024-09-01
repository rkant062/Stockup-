package Java;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAtomicInt {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {
        // Create 10 threads that will increment the counter 1000 times each
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new IncrementTask());
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // The expected counter value is 10,000 (10 threads * 1,000 increments)
        System.out.println("Final Counter Value: " + counter.get()); // Should be 10000
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                counter.incrementAndGet(); // Atomically increments by 1
            }
        }
    }
}
