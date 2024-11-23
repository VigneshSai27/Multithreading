package multithreading.locks.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {
    boolean isAvailable = false;
    ReentrantLock lock;

    public SharedResource(ReentrantLock lock) {
        this.lock = lock;
    }

    public void producer() {
        try {
            lock.lock();
            isAvailable = true;
            System.out.println("Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            System.out.println("Lock released by thread " + Thread.currentThread().getName());
        }
    }
}
