import javax.swing.*;

public class Consumer implements Runnable{
    private final SharedResource<Integer> sharedQueue;
    private final int consumerId;

    public Consumer(SharedResource<Integer> sharedQueue, int consumerId) {
        this.sharedQueue = sharedQueue;
        this.consumerId = consumerId;
    }

    @Override
    public void run() {
        try {
            for(int i=1;i<=10;i++){
                Integer message = sharedQueue.consume();
                if(message!=null){
                    processMessage(message);
                }
                Thread.sleep(500);
            }
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            System.err.println("Consumer "+consumerId+" was interrupted");
        }
    }

    private void processMessage(Integer message){
        System.out.println("Consumer "+consumerId+" processed message: "+message);
    }
}

