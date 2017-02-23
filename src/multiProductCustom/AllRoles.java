package multiProductCustom;

/**
 * Created by Administrator on 2017/2/23.
 */
public class AllRoles {
    public static AppleConsumer[] ac = new AppleConsumer[20];
    public static OrangeConsumer[] oc = new OrangeConsumer[20];

    public static AppleProducer[] ap = new AppleProducer[20];
    public static OrangeProducer[] op = new OrangeProducer[20];

    static{
        BufferCase bf = new BufferCase();
        for(int i=0;i<20;i++){//初始化生产者消费者线程
            ap[i] = new AppleProducer(bf,i);
            op[i] = new OrangeProducer(bf,i);

            ac[i] = new AppleConsumer(bf,i);
            oc[i] = new OrangeConsumer(bf,i);
        }
    }
}
