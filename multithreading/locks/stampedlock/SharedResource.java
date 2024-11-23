package multithreading.locks.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    StampedLock lock;
    int a = 10;

    public SharedResource(StampedLock lock) {
        this.lock = lock;
    }

    public void producer() {
        long stamp = lock.tryOptimisticRead();
        try {
            System.out.println("Read Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(3000);
            if (lock.validate(stamp)) {
                a = 12;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void consumer() {
        long stamp = lock.writeLock();
        try {
            System.out.println("Write Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock(stamp);
            System.out.println("Write Lock released by thread " + Thread.currentThread().getName());
        }
    }
}
