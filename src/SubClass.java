import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

/**
 * 大位数乘法，通过String类型接收用户输入的数字，并按位存进Map集合中，
 * 之后模拟乘法手算的过程，用乘数的每一位，去乘被乘数的每一位，将结果按位保存在新的Map集合中
 *
 * @author Eric
 */
public class SubClass extends SuperClass {
    /*Person person1 = new Person("Tom");
    static Person person2 = new Person("Jack");
    static int i = 2;
    static {
        System.out.println("subclass: " + i);
    }

    public SubClass() {
        System.out.println("subclass constructor");
    }
    public static void main(String[] args) {
        System.out.println("main");
        SubClass b = new SubClass();
    }*/


    public static void main(String[] args){
        int i = 200;
        Integer I = 2;
        System.out.println(i == I);
    }


}

class SuperClass {
    static int i = 1;
    static {
        System.out.println("superclass: " + i);
    }
    public SuperClass() {
        System.out.println("superclass constructor");
    }
}
class Person{
    public Person(String msg){
        System.out.println(msg);
    }
}

