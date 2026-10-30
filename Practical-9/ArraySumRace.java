import java.util.Scanner;
public class ArraySumRace {
    private static final int DEFAULT_SIZE=100000;
    private static final int DEFAULT_THREADS=4;
    public static void main(String[] args)throws InterruptedException{
        int size=DEFAULT_SIZE,threadCount=DEFAULT_THREADS;
        if(args.length>=2){size=Integer.parseInt(args[0]);threadCount=Integer.parseInt(args[1]);}
        if(size<=0||threadCount<=0)throw new IllegalArgumentException("Size and thread count must be positive");
        int[] values=new int[size];for(int i=0;i<size;i++)values[i]=i+1;
        long[] partial=new long[threadCount];Thread[] workers=new Thread[threadCount];
        int chunk=(size+threadCount-1)/threadCount;
        for(int worker=0;worker<threadCount;worker++){
            final int index=worker,start=worker*chunk,end=Math.min(size,start+chunk);
            workers[worker]=new Thread(()->{long sum=0;for(int i=start;i<end;i++)sum+=values[i];partial[index]=sum;});
            workers[worker].start();
        }
        for(Thread worker:workers)worker.join();
        long total=0;for(long part:partial)total+=part;
        long expected=(long)size*(size+1)/2;
        System.out.println("Parallel sum: "+total);System.out.println("Expected sum: "+expected);
    }
}
