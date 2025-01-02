
import java.util.LinkedList;
import java.util.Queue;

public class SharedResource<T> {
    
    private final Queue<T> queue = new LinkedList<>();
    private final int MAX_CAPACITY;
    public SharedResource(int capacity ){
        this.MAX_CAPACITY = capacity;
    }

    public synchronized void produce(T message){
        while(queue.size()==MAX_CAPACITY){
            try{
                System.out.println(Thread.currentThread().getName() + " waiting to produce. Queue is full.");
                wait();

            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
                System.err.println(Thread.currentThread().getName()+" was interrupted");
            }
        }
        queue.add(message);
        System.out.println(Thread.currentThread().getName()+" produced: "+ message);
        notifyAll();
    }


    public synchronized T consume() {
        while (queue.isEmpty()) {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting to consume. Queue is empty.");
                wait(); // Wait if the queue is empty
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println(Thread.currentThread().getName() + " was interrupted while waiting to consume.");
                return null;
            }
        }

        T message = queue.poll();
        System.out.println(Thread.currentThread().getName() + " consumed: " + message);
        notifyAll(); // Notify producers that space is available
        return message;
    }

    

}
