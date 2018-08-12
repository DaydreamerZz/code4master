package vm;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/12 14:33
 * @desc :
 */
public class Test extends Thread {
    volatile boolean stop = false;
    public static void main(String[] args) {
    MyThread myThread = new MyThread();
    myThread.start();
    myThread.interrupt();
    System.out.println(myThread.interruptStatus()); //true
    System.out.println(myThread.interruptStatus()); //false
}


}
class MyThread extends Thread{
    private int i = 5;
    @Override
    public synchronized void run() {
        return;

    }
    boolean interruptStatus(){
        return this.interrupted();
    }
}
