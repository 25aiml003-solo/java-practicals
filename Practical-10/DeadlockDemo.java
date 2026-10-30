public class DeadlockDemo {
    private static final Object LOCK_A=new Object();
    private static final Object LOCK_B=new Object();
    public static void main(String[] args)throws InterruptedException{
        Thread first=new Thread(()->{synchronized(LOCK_A){synchronized(LOCK_B){System.out.println("Thread A completed");}}});
        Thread second=new Thread(()->{synchronized(LOCK_A){synchronized(LOCK_B){System.out.println("Thread B completed");}}});
        first.start();second.start();first.join();second.join();
        System.out.println("Consistent lock ordering prevents deadlock.");
    }
}
