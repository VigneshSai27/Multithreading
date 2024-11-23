package multithreading.example1;

public class MonitorThread2 extends Thread{
    MonitorLockExample obj;
    public MonitorThread2(MonitorLockExample obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        obj.task2();
    }
}
