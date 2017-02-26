package singleProductCustom;

/**
 * Created by Administrator on 2017/2/23.
 *
 * 消费者（Custom）要在一个盒子里面消费东西，生产者（Product）要把生产好的东西放在盒子里面，
 * 如果盒子里面没有东西消费者是不能取东西，生产者生产好了通知（notify）消费者可以在盒子里面拿东西了，
 * 此时盒子有东西不能生产，生产者要等待（wait）；当消费者拿了之后通知(notify)生产者，我把盒子里面的东西拿了，
 * 盒子空了你去生产吧，要等待(wait)生产者生产
 */
public class ThreadBox {
    private int content ;//产品
    private boolean has ;//标识盒子是否有东西
    public static void main(String[] args) {
        ThreadBox box =new ThreadBox();
        Thread pro =new Thread(new Product(box),"生产者");
        Thread cus =new Thread(new Custom(box),"消费者");
        pro.start();
        cus.start();
    }
    //生产好的添加到盒子里面
    public synchronized void setContent(int content) {
        if(has){
            try {
                wait();//盒子有东西就等待
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        has=true;
        notify();
        this.content = content;
    }
    public synchronized int getContent() {
        if(has==false){
            try {
                wait();//盒子没有东西等待
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        has=false;
        notify();//通知生产者，盒子没有东西了
        return content;
    }
}
class Product implements Runnable{
    private int content =1;
    ThreadBox box;
    public Product(ThreadBox box) {
        // TODO Auto-generated constructor stub
        this.box=box;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("product thread starting");
        while (true) {
            System.out.println("product thread");
            System.out.println("已生产的商品->"+content);
            box.setContent(content);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            content++;
        }
    }

}
class Custom  implements Runnable{
    ThreadBox box;
    public Custom(ThreadBox box) {
        // TODO Auto-generated constructor stub
        this.box=box;
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("custom thread starting");
        while (true) {
            System.out.println("custom thread");
            System.out.println("已消费的商品->"+box.getContent());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
