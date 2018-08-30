package codeexam.pinduoduo.sec;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 8/30/2018 8:13 PM
 * desc  :
 */
public class Main33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double count = display(a, b);
        return;
    }

    public static double display(int a, int b) {
        int t, k, i;
        int[] book = new int[3000];
        int[] count = new int[100];

        count[0] = a / b; // 小数点左边的数
        t = a%b; // 余数
        book[t] = 1; // 记下第一个余数

        count[1] = (t * 10) / b; // 小数点后一位数
        t = (t*10)%b; //继续求余

        k = 2;
        while (book[t] == 0) {  //循环直到出现 第一次出现 的 余数
            count[k] = (t * 10) / b;
            t = (t*10)%b;
            k++;
        }

        /*cout << count[0] << ".(";
        for (i = 1; i < k; i++)cout << count[i];
        cout << ")";*/
        for(int j = 1; j < k; j++)
            System.out.println(count[j]);
        return 0;
    }
}
