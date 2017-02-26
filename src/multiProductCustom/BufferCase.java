package multiProductCustom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/23.
 */
public class BufferCase {
    private static List<String> buffer = new ArrayList<String>();
    private static List<String> log = new ArrayList<String>();
    //制造缓存内容
    public synchronized boolean inBuffer(String goods){
        if(buffer.size()==20)
            return false;
        else if(buffer.add(goods))
            return true;
        else
            return false;
    }
    //消费缓存内容
    public synchronized String outBuffer(int type){
        for(int i=0;i<buffer.size();i++){
            if(type==1){
                if(buffer.get(i).equals("apple")){
                    buffer.remove(i);
                    return new String("apple");
                }
            }
            if(type==2){
                if(buffer.get(i).equals("orange")){
                    buffer.remove(i);
                    return new String("orange");
                }
            }
        }
        return null;
    }
    //写入日志内容
    public synchronized void inLog(String log){
        this.log.add(log);
    }
    //清除日志内容
    public static synchronized void clearLog(){
        log.clear();
    }
    //输出日志内容
    public static List<String> outLog(){
        return log;
    }
    //输出缓存内容
    public static List<String> outBuffer(){
        return buffer;
    }
}
