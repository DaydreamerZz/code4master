package multithread.producerconsumer;

import java.util.ArrayList;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/12 16:26
 * @desc :
 */
public class Factory {

    private ArrayList<String> goods = new ArrayList<>();
    private static int index;

    public synchronized void add(){
        try{
            if(goods.size() == 1){
                this.wait();
            }
            goods.add("apple " + ++index);
            this.notify();
            System.out.println("add new: " + goods.get(0));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void remove(){
        try{
            /*if(goods.size() == 0){
                this.wait();
            }*/
            while(goods.size() == 0){
                this.wait();
            }
            String goodStr = goods.get(0);
            goods.remove(0);
//            this.notify();
            this.notifyAll();
            System.out.println("remove : " + goodStr);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
