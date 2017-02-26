package multiProductCustom;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AppleConsumer extends Thread{
    public BufferCase buffer = null;
    int time = 2000;//运行周期
    boolean flag=true;//是否暂停
    int id;//消费者id
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getTime(){
        return this.time;
    }
    public AppleConsumer(BufferCase bf,int id){
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
            //消费苹果

            synchronized(buffer){
                if(flag==false)
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                String goods = null;
                goods = buffer.outBuffer(1);
                if(goods==null)
                    buffer.inLog("苹果消费者"+id+"消费苹果失败");
                else
                    buffer.inLog("苹果消费者"+id+"消费苹果成功");
            }
            super.run();
        }
    }
}
