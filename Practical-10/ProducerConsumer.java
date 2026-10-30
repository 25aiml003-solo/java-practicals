import java.util.ArrayDeque;
import java.util.Queue;
class BoundedBuffer {
    private final Queue<Integer> queue=new ArrayDeque<>();
    private final int capacity;
    BoundedBuffer(int capacity){this.capacity=capacity;}
    synchronized void put(int value)throws InterruptedException{
        while(queue.size()==capacity)wait();
        queue.add(value);System.out.println("Produced: "+value);notifyAll();
    }
    synchronized int take()throws InterruptedException{
        while(queue.isEmpty())wait();
        int value=queue.remove();System.out.println("Consumed: "+value);notifyAll();return value;
    }
}
public class ProducerConsumer {
    private static final int ITEM_COUNT=5;
    public static void main(String[] args)throws InterruptedException{
        BoundedBuffer buffer=new BoundedBuffer(2);
        Thread producer=new Thread(()->{try{for(int item=1;item<=ITEM_COUNT;item++)buffer.put(item);}catch(InterruptedException e){Thread.currentThread().interrupt();}});
        Thread consumer=new Thread(()->{try{for(int item=1;item<=ITEM_COUNT;item++)buffer.take();}catch(InterruptedException e){Thread.currentThread().interrupt();}});
        producer.start();consumer.start();producer.join();consumer.join();
    }
}
