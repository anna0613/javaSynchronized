package ways.Thread;

/**
 * Created by Administrator on 2017/2/26.
 */

// 通过继承Thread类来创建线程类
public class ThreadByExtends extends Thread {
    private int i;
String s = "";
    @Override
    public void run() {
        synchronized(s) {//this不能保证同步，锁是对象级的
            // 当线程类继承Thread类时，直接使用this即可获取当前线程句柄。
            // 因此可以直接调用getName()方法返回当前线程的名称。
            System.out.println("当前线程名称是：" + getName());

            for (; i < 5; i++) {
                System.out.println(getName() + ":" + i);
                try {
                    // 保证让别的线程也有执行的机会
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static void main(String[] args) {
        // 静态方法没有this，只能通过Thread.currentThread获取当前线程句柄
        System.out.println(Thread.currentThread().getName());

        // 创建、并启动第一条线程
        new ThreadByExtends().start();
        // 创建、并启动第二条线程
        new ThreadByExtends().start();
    }
}
