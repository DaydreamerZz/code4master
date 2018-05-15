package video.video3queuestack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 20:33
 * @desc : 两个队列实现栈
 */
public class TwoQueueStack {

    private Deque<Integer> queue;
    private Deque<Integer> helper;

    public TwoQueueStack(){
        queue = new ArrayDeque<>();
        helper = new ArrayDeque<>();
    }

    public void push(int value){
        queue.add(value);
    }

    public int pop(){
        if(queue.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Empty stack");
        }
        while(queue.size() > 1){
            helper.add(queue.poll());
        }
        int result = queue.poll();
        Deque<Integer> tmp = helper;
        helper = queue;
        queue = tmp;
        return result;

    }

    public static void main(String[] args) {
        TwoQueueStack stack = new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        return;
    }
}
