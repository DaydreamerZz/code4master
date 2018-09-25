package codeexam.passed.iqiyi;

import java.util.Arrays;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/15/2018 9:55 AM
 * desc  :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String sub1 = line.substring(0, 3);
        String sub2 = line.substring(3, 6);
//        System.out.println(sub1 + sub2);

        char[] chars1 = sub1.toCharArray();
        char[] chars2 = sub2.toCharArray();
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < 3; i++){
            sum1 += (chars1[i] - '0');
            sum2 += (chars2[i] - '0');
        }
        if(sum1 == sum2){
            System.out.println(0);
            return;
        }
        int res1 = 0;
        int res2 = 0;


        /*if(sum1 > sum2){ //已有的更大，需要减少 696123  669 123
            Arrays.sort(chars1);
            for(int i = 2; i >= 0; i--){
                int tmp = chars1[i] - '0';
                sum1 -= tmp;
                res1++;
                if(sum1 <= sum2)
                    break;
            }

        }else{ //需要增加 123 999 6 27
            Arrays.sort(chars1);

            for(int i = 0; i < chars1.length; i++){
                int tmp = 9 - (chars1[i]-'0');
                sum1 += tmp;
                res2++;
                if(sum1 >= sum2){
                    break;
                }

            }
        }*/



        Arrays.sort(chars1);
        for(int i = 2; i >= 0; i--){
            int tmp = chars1[i] - '0';
            sum1 -= tmp;
            res1++;
            if(sum1 <= sum2)
                break;
        }
        Arrays.sort(chars1);
        for(int i = 0; i < chars1.length; i++){
            int tmp = 9 - (chars1[i]-'0');
            sum1 += tmp;
            res2++;
            if(sum1 >= sum2){
                break;
            }
        }
        System.out.println(Math.min(res1, res2));

        return;
    }
}
