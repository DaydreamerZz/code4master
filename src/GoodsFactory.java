import java.util.ArrayList;

public class GoodsFactory {
    private ArrayList<String> goods = new ArrayList<>();
    private static int index;

    public synchronized void add(){
        try{
            if(goods.size() == 2){
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


class Producer extends Thread{

    private GoodsFactory factory;
    public Producer(GoodsFactory factory){
        this.factory = factory;

    }

    public void produce(){
        factory.add();
    }
}

class Consumer extends Thread{
    private GoodsFactory factory;
    public Consumer(GoodsFactory factory){
        this.factory = factory;

    }

    public void consume(){
        factory.remove();

    }
}

class Main{
    public static void main(String[] args){
        GoodsFactory factory = new GoodsFactory();

        Producer producer = new Producer(factory);
        ThreadP pThread = new ThreadP(producer);
        pThread.start();

        Consumer consumer1 = new Consumer(factory);
        Consumer consumer2 = new Consumer(factory);
        ThreadC cThread1 = new ThreadC(consumer1);
        ThreadC cThread2 = new ThreadC(consumer2);

        cThread1.start();
        cThread2.start();


    }
}

class ThreadP extends Thread{
    private Producer producer;

    public ThreadP(Producer producer){
        this.producer = producer;
    }

    @Override
    public void run() {
        while(true)
            producer.produce();
    }
}

class ThreadC extends Thread{
    private Consumer consumer;

    public ThreadC(Consumer consumer){
        this.consumer = consumer;
    }

    @Override
    public void run() {
        while(true)
            consumer.consume();
    }
}
