package multithreading.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class MainApp {
    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(); // same lock obj is used for both shared resources

        SharedResource sharedResource1 = new SharedResource(lock);
        Thread t1 = new Thread(() -> {
            sharedResource1.producer();
        });

        SharedResource sharedResource2 = new SharedResource(lock);
        Thread t2 = new Thread(() -> {
            sharedResource2.producer();
        });

        t1.start();
        t2.start();
        System.out.println("Main thread ended");
    }
}
