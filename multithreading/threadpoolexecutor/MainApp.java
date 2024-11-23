package multithreading.threadpoolexecutor;

import java.util.concurrent.*;

public class MainApp {
    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4,
                10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(2),
                new CustomThreadFactory(), new CustomRejectHandler());

        for (int i = 1; i <= 6; i++) {
            executor.submit(() -> {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task processed by: " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();
    }
}

class CustomRejectHandler implements RejectedExecutionHandler {
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        System.out.println("Task Rejected: " + r.toString());
    }
}

class CustomThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setPriority(Thread.NORM_PRIORITY);
        return t;
    }
}