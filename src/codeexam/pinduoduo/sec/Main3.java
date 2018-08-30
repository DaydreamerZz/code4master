package codeexam.pinduoduo.sec;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 8/30/2018 6:58 PM
 * desc  :
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
//        int[] res = calculate(a, b);
//        System.out.println(res[0] + " " + res[1]);
        f(a, b);
        return;
    }



    static void f(int a, int b){
        List t1 = new ArrayList();
        List t2 = new ArrayList();

        int p = - 1;
        while(true){

            t1.add(a/b);
            int x = a % b;
            if(x == 0) break;

            p = t2.indexOf(x);

            if(p >= 0) break;
            else
                t2.add(x);

            a = x*10;
        }

        if(p < 0){
            System.out.println(t1.size()-1 + " " + 0);
        }else{
            System.out.println(0 + " " + (t1.size()-1));
        }

    }

}
