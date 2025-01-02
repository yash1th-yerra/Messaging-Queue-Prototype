public class Producer implements Runnable {
    private final SharedResource<Integer> sharedQueue;
    private final int producerId;
    public Producer(SharedResource<Integer> sharedQueue,int producerId){
        this.sharedQueue = sharedQueue;
        this.producerId = producerId;
    }


    @Override
    public void run() {
        try{
            for(int i=1;i<=10;i++){
                int message = i+(producerId*100);
                sharedQueue.produce(message);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Producer "+producerId+" was interrupted");
        }
    }
}
