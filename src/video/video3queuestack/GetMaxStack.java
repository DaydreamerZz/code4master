package video.video3queuestack;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/15 20:04
 * @desc : 可以拿到最大值的栈
 */
public class GetMaxStack {

    private int stackSize;
    private int[] stack;
    private int[] maxStack;
    private int index;
    public GetMaxStack(int stackSize){
        this.stackSize = stackSize;
        stack = new int[stackSize];
        maxStack = new int[stackSize];
        index = 0;
    }


    public void push(int value){
        if(index == stackSize){
            throw new ArrayIndexOutOfBoundsException("Stack full");
        }else{
            if(index == 0){ //第一次入栈
                stack[index] = value;
                maxStack[index] = value;
                index++;
            }else{
                int max = maxStack[index-1];
                stack[index] = value;
                maxStack[index] = (max > value ? max : value);
                index++;
            }

        }

    }
    public int pop(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }else{

            return stack[--index];
        }
    }

    public int peek(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }
        return maxStack[index-1];
    }

    public int currentMax(){
        if(index == 0){
            throw new ArrayIndexOutOfBoundsException("Stack Empty");
        }
        return maxStack[index-1];
    }

    public static void main(String[] args) {
        /*GetMaxStack stack = new GetMaxStack(10);
        stack.push(1);
        stack.push(10);
        stack.push(5);
        stack.push(7);
        stack.push(20);

        System.out.println(stack.currentMax());

        System.out.println(stack.pop() + " max: " + stack.currentMax());
        System.out.println(stack.pop() + " max: " + stack.currentMax());
        System.out.println(stack.pop() + " max: " + stack.currentMax());
        System.out.println(stack.pop() + " max: " + stack.currentMax());
        System.out.println(stack.pop() + " max: " + stack.currentMax());*/

        GetMaxStack stack1 = new GetMaxStack(10);
		stack1.push(3);
		System.out.println(stack1.currentMax());
		stack1.push(4);
		System.out.println(stack1.currentMax());
		stack1.push(1);
		System.out.println(stack1.currentMax());

		System.out.println(stack1.pop());
		System.out.println(stack1.currentMax());

		System.out.println("=============");

		GetMaxStack stack2 = new GetMaxStack(10);
		stack2.push(4);
		System.out.println(stack2.currentMax());
		stack2.push(3);
		System.out.println(stack2.currentMax());
		stack2.push(1);
		System.out.println(stack2.currentMax());
		System.out.println(stack2.pop());
		System.out.println(stack2.currentMax());


        return;
    }
}
