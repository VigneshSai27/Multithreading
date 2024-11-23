package multithreading.example2;

public class SharedResource {
    boolean itemsAvailable = false;

    public synchronized void addItem() {
        System.out.println("Item added by: " + Thread.currentThread().getName() + " and invoking all other threads");
        itemsAvailable = true;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        notifyAll();
    }

    public synchronized void consumeItem() {
        while (!itemsAvailable) {
            try {
                System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting now");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Item consumed by: " + Thread.currentThread().getName());
        itemsAvailable = false;
    }
}

// sleep(Timed waiting) - do not release monitor lock
// wait, notify, stop(Waiting, Blocked)- releases monitor lock
