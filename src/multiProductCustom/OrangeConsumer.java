package multiProductCustom;

/**
 * Created by Administrator on 2017/2/23.
 */
public class OrangeConsumer extends Thread {
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
    public OrangeConsumer(BufferCase bf,int id){
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
            //消费橘子
            synchronized(buffer){
                if(flag==false)
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                String goods = null;
                goods = buffer.outBuffer(2);
                if(goods==null)
                    buffer.inLog("橘子消费者"+id+"消费橘子失败");
                else
                    buffer.inLog("橘子消费者"+id+"消费橘子成功");
            }
            super.run();
        }
    }

}
