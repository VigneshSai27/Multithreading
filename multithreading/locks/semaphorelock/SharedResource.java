package multithreading.locks.semaphorelock;

import java.util.concurrent.Semaphore;

public class SharedResource {

    Semaphore lock;

    public SharedResource(Semaphore lock) {
        this.lock = lock;
    }

    public void producer() {
        try {
            lock.acquire();
            System.out.println("Read Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.release();
            System.out.println("Read Lock released by thread " + Thread.currentThread().getName());
        }
    }
}
