package multithread.producerconsumer;

/**
 * author : Bruce Zhao
 * email  : zhzh402@163.com
 * date   : 2018/4/12 16:55
 * desc   :
 */
public class Consumer {

    private Factory factory;

    public Consumer(Factory factory){
        this.factory = factory;
    }

    public void consume(){
        factory.remove();
    }
}
