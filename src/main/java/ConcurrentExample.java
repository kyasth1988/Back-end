import java.util.concurrent.*;

public class ConcurrentExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        String str="";
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FutureTask<String> futureTask = (FutureTask<String>) executorService.submit(()->{
            return "Hello World";
        });
        if(futureTask.isDone() && !futureTask.isCancelled()){
            str = futureTask.get();
        }
        System.out.print(str);
    }
}
