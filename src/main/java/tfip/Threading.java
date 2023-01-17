package tfip;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Threading {
    private Threading() {
    }

    public static void main(String[] args) {
        // Thread thread1 = new Thread(new Runnable() {
        //     @Override
        //     public void run(){
        //         for (int i=0;i<5;i++){
        //             System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
        //         }
        //     }    
        // });
        // thread1.start();
        
        MyRunnableImplementation mRI = new MyRunnableImplementation("Task1");
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("Task2");
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("Task3");
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("Task4");
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("Task5");
        // Thread thread2 = new Thread(mRI);
        // thread2.start();
        // Thread thread3 = new Thread(mRI);
        // thread3.start();

        //newSingleThreadExecutor (single "counter" only, can only process finish 1 thread before starting another thread)
        // ExecutorService executorService = Executors.newSingleThreadExecutor();
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.shutdown();

        //newFixedThreadPool (multithread with a param to decide the num of "counters" available, can process multiple thread simultaneously)
        // ExecutorService executorService = Executors.newFixedThreadPool(3);
        // executorService.execute(mRI);
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.execute(mRI4);
        // executorService.execute(mRI5);
        // executorService.shutdown();

        //newCachedThreadPool (multithread that auto determines how many "counters" need to be open)
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(mRI);
        executorService.execute(mRI2);
        executorService.execute(mRI3);
        executorService.execute(mRI4);
        executorService.execute(mRI5);
        executorService.shutdown();
    }
}
