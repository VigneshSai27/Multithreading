package multithreading.locks.reentrantlockreadwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainApp {
    public static void main(String[] args) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        SharedResource sharedResource1 = new SharedResource(lock);
        Thread t1 = new Thread(() -> {
            sharedResource1.producer();
        });

        SharedResource sharedResource2 = new SharedResource(lock);
        Thread t2 = new Thread(() -> {
            sharedResource1.consumer();
        });

        Thread t3 = new Thread(() -> {
            sharedResource2.consumer();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
