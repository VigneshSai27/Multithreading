package multithreading.example1;

public class MainApp {
    public static void main(String[] args) {
        MonitorLockExample obj=new MonitorLockExample();
        MonitorThread1Runnable runnableObj = new MonitorThread1Runnable(obj);

        MonitorThread2 t2 = new MonitorThread2(obj);
        Thread t1=new Thread(runnableObj);
        Thread t3=new Thread(obj::task3);
        Thread t4=new Thread(obj::task4);
        t1.start();
        t2.start();
        t3.start();

        try {
            t2.join(); // Main thread waits till thread gets completed
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        t4.start();

        System.out.println("Current Thread: "+ Thread.currentThread().getName()+" "+t1.getPriority());
    }
}
