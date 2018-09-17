import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/7 16:43
 * @desc :
 */
public class file {

    static file a = new file();
    {
        System.out.println("c");
    }
    static{
        System.out.println("S");
    }
    file(){};
    public static void main(String[] args) {

        new file();
    }
}
