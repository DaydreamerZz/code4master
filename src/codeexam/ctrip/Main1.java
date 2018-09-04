package codeexam.ctrip;

import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/4/2018 7:29 PM
 * desc  :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();
        String s = Long.toBinaryString(l);
        char[] chars = s.toCharArray();

        int res = 0;
        for(int i = 0; i < chars.length; i++){
            if(chars[i] == '1')
                res++;
        }
        System.out.println(res);
        return;
    }
}
