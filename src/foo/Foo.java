package foo;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Foo {
    private int x = 100;

    public int getX() {
        return x;
    }

    /*public synchronized int fix(int y) {
        x = x - y;
        System.out.println("线程"+Thread.currentThread().getName() + "运行结束，减少“" + y
                + "”，当前值为：" + x);
        return x;
    }*/

    public int fix(int y) {
        synchronized(this) {
            x = x - y;
        }
            System.out.println("线程" + Thread.currentThread().getName() + "运行结束，减少“" + y
                    + "”，当前值为：" + x);
        return x;
    }
}
