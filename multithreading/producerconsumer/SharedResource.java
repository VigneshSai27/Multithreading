package multithreading.producerconsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
    Queue<Integer> queue;
    int bufferSize;

    public SharedResource(int bufferSize) {
        this.queue = new LinkedList<>();
        this.bufferSize = bufferSize;
    }

    public synchronized void addItem(int item) {
        while (queue.size() == bufferSize) {
            System.out.println("Queue is full. Waiting");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(item);
        System.out.println(item + " has been added successfully into queue by thread " + Thread.currentThread().getName());
        notifyAll();
    }

    public synchronized int consumeItem() {
        while (queue.isEmpty()) {
            System.out.println("No items to consume");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int item = queue.poll();
        System.out.println(item + " has been consumed by thread " + Thread.currentThread().getName());
        notifyAll();
        return item;
    }
}
