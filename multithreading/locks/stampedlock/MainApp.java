package multithreading.locks.stampedlock;


import java.util.concurrent.locks.StampedLock;

public class MainApp {
    public static void main(String[] args) {
        StampedLock lock = new StampedLock();
        SharedResource sharedResource1 = new SharedResource(lock);
        Thread t1 = new Thread(() -> {
            sharedResource1.producer();
        });

        SharedResource sharedResource2 = new SharedResource(lock);
        Thread t2 = new Thread(() -> {
            sharedResource1.producer();
        });

        Thread t3 = new Thread(() -> {
            sharedResource2.consumer();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
