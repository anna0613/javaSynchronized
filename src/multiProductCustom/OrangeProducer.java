package multiProductCustom;

/**
 * Created by Administrator on 2017/2/23.
 */
public class OrangeProducer extends Thread{
    BufferCase buffer = null;
    int time= 2000 ;//运行周期
    boolean flag=true;//是否暂停
    int id;//消费者id
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public OrangeProducer(BufferCase bf,int id){
        buffer = bf;
        this.id = id;
    }

    @Override
    public void run() {
        while(true){
            // 设定运行周期
            try {
                sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //生产橘子
            if(flag==true)
                synchronized(buffer){
                    String goods = new String("orange");
                    if(buffer.inBuffer(goods))
                        buffer.inLog("橘子生产者"+id+"放入橘子成功");
                    else
                        buffer.inLog("橘子生产者"+id+"放入橘子失败");
                }
            super.run();
        }
    }
}
