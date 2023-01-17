package tfip;

public class MyRunnableImplementation implements Runnable {
    private String taskName;
    //Constructors
    public MyRunnableImplementation() {
    }
    public MyRunnableImplementation(String taskName) {
        this.taskName = taskName;
    }
    //Methods
    @Override
    public void run() {
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName() + "\t" + taskName + "\tRunnable ..." + i);
        }
    }
}
