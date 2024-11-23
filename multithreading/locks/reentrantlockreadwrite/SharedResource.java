package multithreading.locks.reentrantlockreadwrite;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    ReadWriteLock lock;

    public SharedResource(ReadWriteLock lock) {
        this.lock = lock;
    }

    public void producer() {
        try {
            lock.readLock().lock();
            System.out.println("Read Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.readLock().unlock();
            System.out.println("Read Lock released by thread " + Thread.currentThread().getName());
        }
    }

    public void consumer() {
        try {
            lock.writeLock().lock();
            System.out.println("Write Lock acquired by thread " + Thread.currentThread().getName());
            Thread.sleep(4000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.writeLock().unlock();
            System.out.println("Write Lock released by thread " + Thread.currentThread().getName());
        }
    }
}
