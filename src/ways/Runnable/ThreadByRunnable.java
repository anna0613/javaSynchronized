package ways.Runnable;

/**
 * Created by Administrator on 2017/2/26.
 */
/**
 * 通过实现Runnable接口来创建线程类
 * 1.Runnable非常适合多个相同线程来处理同一份资源的情况
 * 2.Runnable可以避免由于Java的单继承机制带来的局限
 * 3.如果想获取当前线程句柄，只能用Thread.currentThread()方法
 */
public class ThreadByRunnable implements Runnable {
    private int i;

    @Override
    public void run() {
//        synchronized (this) {
            System.out.println("当前线程名称是：" + Thread.currentThread().getName());

            for (; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + ":" + i);

                try {
                    // 因为sleep是静态方法，所以不需要通过Thread.currentThread()方法获取当前线程句柄
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
//        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        ThreadByRunnable st = new ThreadByRunnable();
        new Thread(st, "新线程1").start();
        new Thread(st, "新线程2").start();
    }
}
