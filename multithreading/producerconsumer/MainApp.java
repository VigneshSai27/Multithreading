package multithreading.producerconsumer;

public class MainApp {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                sharedResource.addItem(i);
            }
        }, "producer");

        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 6; i++) {
                sharedResource.consumeItem();
            }
        }, "consumer");

        producerThread.start();
        consumerThread.start();
        System.out.println("Main thread ended");
    }
}
