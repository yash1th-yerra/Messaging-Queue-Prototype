## 1. Key Points:

    Multiple Producers and Consumers: Demonstrates scalability by having two producers and two consumers.
    Thread Naming: Threads are named (e.g., "Producer-1") for clearer log output.
    Thread Joining: The main thread waits for all producer and consumer threads to complete using join().

## 2. Complete Project Structure

For clarity, here's how the project structure looks:
```
messagequeue/
├── Consumer.java
├── Main.java
├── Producer.java
└── SharedResource.java
```
Ensure all classes are in the messagequeue package.


## 3. Sample Output

When you run the MessageQueueExample class, you might see output similar to the following:
```
Producer-1 produced: 101
Consumer-1 consumed: 101
Consumer 1 processed message: 101
Producer-2 produced: 201
Consumer-2 consumed: 201
Consumer 2 processed message: 201
Producer-1 produced: 102
Consumer-1 consumed: 102
Consumer 1 processed message: 102
Producer-2 produced: 202
Consumer-2 consumed: 202
Consumer 2 processed message: 202
Producer-1 produced: 103
Consumer-1 consumed: 103
Consumer 1 processed message: 103
Producer-2 produced: 203
Consumer-2 consumed: 203
Consumer 2 processed message: 203
```
All producers and consumers have finished processing.

Explanation:

- Producers (Producer-1 and Producer-2) produce unique messages (e.g., 101, 201).
- Consumers (Consumer-1 and Consumer-2) consume and process these messages.
- Synchronization ensures that producers wait when the queue is full and consumers wait when the queue is empty.
- Multiple Threads operate concurrently, demonstrating thread-safe message queuing.

## 4. Key Takeaways
- Manual Synchronization: Using synchronized, wait(), and notifyAll() allows precise control over thread communication but requires careful handling to avoid issues like deadlocks.
- Queue Capacity: Limiting the queue size (e.g., MAX_CAPACITY = 5) prevents producers from overwhelming consumers.
- Thread Safety: Ensuring that access to the shared queue is thread-safe is crucial in concurrent programming.
- Scalability: The implementation can be easily scaled to multiple producers and consumers by creating additional threads.
- Graceful Shutdown: Properly handling InterruptedException ensures that threads can be gracefully interrupted and terminated.

## 5. Enhancements and Best Practices

While the above implementation is functional, here are some enhancements and best practices to consider:

- Use notifyAll() Instead of notify():
        Ensures that all waiting threads are notified, preventing potential thread starvation.

- Error Handling:
        Implement more robust error handling and possibly logging mechanisms for production systems.

- Graceful Shutdown:
        Implement mechanisms to gracefully shut down producers and consumers, especially in real-world applications.

- Avoid Busy Waiting:
        Ensure that threads don't consume CPU cycles while waiting by properly using wait() and notifyAll().

- Thread Naming and Identification:
        Properly name and manage threads for easier debugging and monitoring.

- Use Higher-Level Concurrency Utilities:
        For more complex systems, consider using higher-level concurrency utilities from java.util.concurrent like Semaphore, CountDownLatch, or Exchanger.

## 6. Conclusion

This implementation provides a foundational understanding of how message queues work in a multi-threaded environment using basic Java constructs. By manually handling synchronization, producers and consumers can communicate effectively, ensuring that messages are produced and consumed in a thread-safe manner.

For more advanced and scalable applications, leveraging Java's concurrent utilities like BlockingQueue is recommended, as they provide optimized and battle-tested implementations for common concurrency patterns.

Feel free to customize and extend this implementation based on your specific requirements!
