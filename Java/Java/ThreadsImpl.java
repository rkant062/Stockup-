package Java;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class MyThread extends Thread {
    public void run() {
        System.out.println("Thread is running");
    }
}

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable is running");
    }
}

class MyCallable implements Callable<String> {
    public String call() throws Exception {
        return "Callable result";
    }
}

public class ThreadsImpl {
    public static void main(String[] args) throws Exception {
        Thread thread1 = new MyThread();
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();

        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<String> result = executor.submit(new MyCallable());
        System.out.println(result.get());
        executor.shutdown();
    }
}
