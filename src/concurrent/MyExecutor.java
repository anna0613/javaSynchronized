package concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/2/26.
 */
public class MyExecutor extends Thread
{
    private int index;
    public MyExecutor(int i){
        this.index=i;
    }
    public void run(){
            try {
                System.out.println("[" + this.index + "] start....");
                Thread.sleep((int) (Math.random() * 1000));
                System.out.println("[" + this.index + "] end.");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    public static void main(String args[]){
        //线程池中可用的线程数一定，当线程都被占用时，其他线程等待，
        // 直到池中某个线程结束，等待线程才可依此获得执行机会
        ExecutorService service = Executors.newFixedThreadPool(5);
        for(int i=0;i<10;i++){
//            service.execute(new MyExecutor(i));
            service.submit(new MyExecutor(i));
        }
//        System.out.println("submit finish");
        service.shutdown();
    }
}
