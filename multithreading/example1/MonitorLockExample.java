package multithreading.example1;

public class MonitorLockExample {
    public synchronized void task1() {
        try {
            System.out.println("Inside task1");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void task2() {
        synchronized (this) {
            System.out.println("Inside task2");
        }
    }

    public void task3() {
        System.out.println("Inside task3");
    }

    public void task4() {
        System.out.println("Inside task4");
    }
}
