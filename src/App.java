
public class App {
    public static void main(String[] args) {
        int queueCapacity = 5;
        SharedResource<Integer> sharedQueue = new SharedResource<>(queueCapacity);

        // Create producers
        Producer producer1 = new Producer(sharedQueue, 1);
        Producer producer2 = new Producer(sharedQueue, 2);

        // Create consumers
        Consumer consumer1 = new Consumer(sharedQueue, 1);
        Consumer consumer2 = new Consumer(sharedQueue, 2);

        // Initialize threads
        Thread producerThread1 = new Thread(producer1, "Producer-1");
        Thread producerThread2 = new Thread(producer2, "Producer-2");
        Thread consumerThread1 = new Thread(consumer1, "Consumer-1");
        Thread consumerThread2 = new Thread(consumer2, "Consumer-2");

        // Start threads
        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();

        // Wait for all threads to finish
        try {
            producerThread1.join();
            producerThread2.join();
            consumerThread1.join();
            consumerThread2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Main thread was interrupted.");
        }

        System.out.println("All producers and consumers have finished processing.");
    }
}
