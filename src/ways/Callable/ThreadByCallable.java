package ways.Callable;

/**
 * Created by Administrator on 2017/2/26.
 */
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

// 实现Callable接口来实现线程
public class ThreadByCallable implements Callable<Integer> {

    @Override
    public Integer call() {
//        synchronized (this) {
            System.out.println("当前线程名称是：" + Thread.currentThread().getName());

            int i = 0;
            for (; i < 5; i++) {
                System.out.println("循环变量i的值：" + i);
            }

            // call()方法有返回值
            return i;
//        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadByCallable rt1 = new ThreadByCallable();
        ThreadByCallable rt2 = new ThreadByCallable();

        // 使用FutureTask来包装Callable对象
        FutureTask<Integer> task1 = new FutureTask<Integer>(rt1);
        FutureTask<Integer> task2 = new FutureTask<Integer>(rt2);
        new Thread(task1, "有返回值的线程1").start();
        new Thread(task2, "有返回值的线程2").start();
        try {
            // 获取线程返回值
            System.out.println("子线程的返回值：" + task1.get());
            System.out.println("子线程的返回值：" + task2.get());
        } catch (Exception ex) {
            System.out.println("asdf");
            ex.printStackTrace();
        }

    }
}
