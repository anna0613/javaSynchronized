package ths;

/**
 * Created by Administrator on 2017/2/13.
 */
public class Thread2 {
    public void m4t1() {
        synchronized(this) {
            int i = 5;
            while( i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
        }
    }
    public synchronized void m4t2() {
//        synchronized(this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ie) {
                }
            }
//        }
    }
    public static void main(String[] args) {
        final Thread2 myt2 = new Thread2();
        //匿名类
        /*
        return new Runnable { public void run() {} }
        等价于
        class myThread  implements Runnable {
            public void run() {}
        }
        return new myThread()
        */
        Thread t1 = new Thread(  new Runnable() {  public void run() {  myt2.m4t1();  }  }, "t1"  );
        Thread t2 = new Thread(  new Runnable() {  public void run() { myt2.m4t2();   }  }, "t2"  );
        t1.start();
        t2.start();
    }
}
