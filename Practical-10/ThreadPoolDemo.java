import java.util.concurrent.*;
public class ThreadPoolDemo {
    private static final int POOL_SIZE=3;
    private static final int TASK_COUNT=6;
    public static void main(String[] args)throws InterruptedException{
        ExecutorService pool=Executors.newFixedThreadPool(POOL_SIZE);
        for(int task=1;task<=TASK_COUNT;task++){
            final int taskId=task;
            pool.submit(()->System.out.println("Task "+taskId+" on "+Thread.currentThread().getName()));
        }
        pool.shutdown();
        if(!pool.awaitTermination(1,TimeUnit.MINUTES))pool.shutdownNow();
    }
}
