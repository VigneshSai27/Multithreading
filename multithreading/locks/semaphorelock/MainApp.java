package multithreading.locks.semaphorelock;

import java.util.concurrent.Semaphore;

public class MainApp {
    public static void main(String[] args) {
        Semaphore lock = new Semaphore(2); // allowing 2 objects two enter into critical section(basically, each obj have one lock)
        SharedResource sharedResource1 = new SharedResource(lock);
        Thread t1 = new Thread(() -> {
            sharedResource1.producer();
        });

        SharedResource sharedResource2 = new SharedResource(lock);
        Thread t2 = new Thread(() -> {
            sharedResource2.producer();
        });

        SharedResource sharedResource3 = new SharedResource(lock);
        Thread t3 = new Thread(() -> {
            sharedResource3.producer();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
