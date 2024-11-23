package multithreading.example2;

public class ConsumerTask implements Runnable {
    SharedResource sharedResource;

    public ConsumerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        try {
            System.out.println("Consumer Thread: " + Thread.currentThread().getName());
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sharedResource.consumeItem();
    }
}
