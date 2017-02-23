package multiProductCustom;

/**
 * Created by Administrator on 2017/2/23.
 */
public class Test {
    public static void main(String[] args){
        //开启线程
        for(int i=0;i<20;i++){
            AllRoles.ac[i].start();
            AllRoles.ap[i].start();
            AllRoles.oc[i].start();
            AllRoles.op[i].start();
        }
        /*//暂停线程
        for(int i=0;i<20;i++){
            AllRoles.ac[i].setFlag(false);
            AllRoles.ap[i].setFlag(false);
            AllRoles.oc[i].setFlag(false);
            AllRoles.op[i].setFlag(false);
        }
        //重启线程
        for(int i=0;i<20;i++){
            AllRoles.ac[i].setFlag(true);
            AllRoles.ap[i].setFlag(true);
            AllRoles.oc[i].setFlag(true);
            AllRoles.op[i].setFlag(true);
        }*/
    }
}
