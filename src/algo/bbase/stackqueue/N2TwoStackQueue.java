package algo.bbase.stackqueue;

import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/18 20:46
 * @desc :
 */
public class N2TwoStackQueue<T> {

    public Stack<T> inStack = null;
    public Stack<T> outStack = null;

    public N2TwoStackQueue() {
        inStack = new Stack<T>();
        outStack = new Stack<T>();
    }

    public static void main(String[] args) {
        N2TwoStackQueue<Integer> tsqueue = new N2TwoStackQueue<>();
        tsqueue.add(3);
        System.out.println(tsqueue.peek());
        System.out.println(tsqueue.poll());
        tsqueue.add(1);
        tsqueue.add(4);
        tsqueue.add(5);
        System.out.println(tsqueue.poll());
        System.out.println(tsqueue.poll());
        System.out.println(tsqueue.poll());
        System.out.println(tsqueue.poll());
        return;
    }

    public void add(T value) {
        inStack.push(value);
    }

    public T poll() {
        T res = null;
        if (inStack.isEmpty() && outStack.isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        } else {
            if(outStack.isEmpty()){
                while(!inStack.isEmpty()){
                    outStack.push(inStack.pop());
                }
            }
        }
        res = outStack.pop();
        return res;

    }

    public T peek() {
        if(inStack.isEmpty() && outStack.isEmpty()){
            throw new RuntimeException("Queue is empty!");
        }else {
            if (outStack.isEmpty()) {
                while (!inStack.isEmpty()) {
                    outStack.push(inStack.pop());
                }
            }
        }
        return outStack.peek();
    }
}
