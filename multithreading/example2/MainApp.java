package multithreading.example2;

public class MainApp {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();
        ProducerTask producerTask = new ProducerTask(sharedResource);
        ConsumerTask consumerTask = new ConsumerTask(sharedResource);
        Thread producer = new Thread(producerTask, "producerThread");
        Thread consumer = new Thread(consumerTask, "consumerThread");
        consumer.start();
        producer.start();
        System.out.println(Thread.currentThread().getName() + " thread ended");
    }
}
