package ths;

/**
 * Created by Administrator on 2017/2/12.
 */
public class Thread1  implements Runnable {
    public void run() {
        synchronized(this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);
            }
        }
    }
    public static void main(String[] args) {
        //说明
        /*
        无论synchronized关键字加在方法上还是对象上，它取得的锁都是对象，
        而不是把一段代码或函数当作锁――而且同步方法很可能还会被其他线程的对象访问。
        搞清楚synchronized锁定的是哪个对象，就能帮助我们设计更安全的多线程程序
        */
        Thread1 t1 = new Thread1();
        Thread1 t2 = new Thread1();
        Thread t1a = new Thread(t1, "A1");
        Thread t1b = new Thread(t1, "B1");
//        Thread t2a = new Thread(t2, "A2");
//        Thread t2b = new Thread(t2, "B2");
        t1a.start();
        t1b.start();
//        t2a.start();
//        t2b.start();
    }
}


