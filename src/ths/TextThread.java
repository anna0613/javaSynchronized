package ths;

/**
 * Created by Administrator on 2017/2/13.
 */
public class TextThread {
    public static void main(String[] args) {
        TxtThread tt = new TxtThread();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
        new Thread(tt).start();
//        Thread t1 = new Thread(tt,"a");
//        Thread t2 = new Thread(tt,"b");
//        Thread t3 = new Thread(tt,"c");
//        t1.start();
//        t2.start();
//        t3.start();
    }
}
class TxtThread implements Runnable {
//    int num = 10;
    String str = new String();

    public void run() {
        synchronized (str) {//this
            int num = 10;
            while (num > 0) {
                try {
                    Thread.sleep(1);
                } catch (Exception e) {
                    e.getMessage();
                }
                System.out.println(Thread.currentThread().getName()
                        + " this is " + num--);
            }
            System.out.println("num" + num);
        }
    }
}


