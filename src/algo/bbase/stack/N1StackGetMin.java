package algo.bbase.stack;

import java.util.Stack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/15 19:59
 * @desc :
 */
public class N1StackGetMin {

    public static void main(String[] args) {

        /*MyStack1 stack1 = new MyStack1();
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);
        System.out.println(stack1.popMin());
        System.out.println(stack1.popMin());
        System.out.println(stack1.popMin());
        System.out.println(stack1.popMin());
        System.out.println(stack1.popMin());
        System.out.println(stack1.popMin());
        System.out.println(stack1.popMin());*/


        MyStack2 stack2 = new MyStack2();
        stack2.push(3);
        stack2.push(4);
        stack2.push(5);
        stack2.push(1);
        stack2.push(2);
        stack2.push(1);
        System.out.println(stack2.popMin());
        System.out.println(stack2.popMin());
        System.out.println(stack2.popMin());
        System.out.println(stack2.popMin());
        System.out.println(stack2.popMin());
        System.out.println(stack2.popMin());
        System.out.println(stack2.popMin());

        return;
    }
}

/*
 * 3 4 5 1 2 1
 * 3 - - 1 - 1
 *
 */
class MyStack1{
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> miniStack = new Stack<>();
    int mini = -1;
    public void push(int value){
        dataStack.push(value);
        if(miniStack.isEmpty()){
            miniStack.push(value);
        }else{
            mini = miniStack.peek();
            if(value <= mini){
                miniStack.push(value);
            }
        }
    }
    public int popMin(){
        if(dataStack.isEmpty()){
            return -1;
        }
        int mini = miniStack.peek();
        int value = dataStack.peek();
        if(value == mini){
            miniStack.pop();
        }else {
            value = mini;
        }
        dataStack.pop();
        return value;

    }
}

class MyStack2{
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> miniStack = new Stack<>();
    int mini = -1;
    public void push(int value){
        dataStack.push(value);
        if(miniStack.isEmpty()){
            miniStack.push(value);
        }else {
            mini = miniStack.peek();
            if(value >= mini){
                miniStack.push(mini);
            }else
                miniStack.push(value);
        }
    }

    public int popMin(){
        if(miniStack.isEmpty())
            return -1;
        return miniStack.pop();
    }
}