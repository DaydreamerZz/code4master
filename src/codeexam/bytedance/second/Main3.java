package codeexam.bytedance.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/25 9:38
 * @desc :
1
2
helloworld
hdlrowolle
1
2
abcde
acbde
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = Integer.parseInt(scanner.nextLine());
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < len; i++){
            int tmpLen = Integer.parseInt(scanner.nextLine());
            for(int j = 0; j < tmpLen; j++) {
                list.add(scanner.nextLine());
            }
            System.out.println(process(list));
        }
        return;
    }

    private static String process(ArrayList<String> list) {
        String res = "Sad";
        String s = list.get(0);
        s = s + s;
        char[] chars1 = s.toCharArray();
        for(int i = 1; i < list.size(); i++){
            String s1 = list.get(i);
            char[] arr1 = s1.toCharArray();
            StringBuilder sb = new StringBuilder(s1);
            sb.reverse();
            char[] arr2 = sb.toString().toCharArray();
            boolean check1 = check(chars1, arr1);
            if(check1)
                return "Yeah";
            boolean check2 = check(chars1, arr2);
            if(check2)
                return "Yeah";

        }

        return "Sad";
    }

    private static boolean check(char[] chars1, char[] arr2) {
        for(int i = 0; i < chars1.length; i++){
            boolean flag = true;
            int index = i;
            for(int j = 0; j < arr2.length; j++){
                if(index >= chars1.length){
                    flag = false;
                    break;
                }

                if(chars1[index] != arr2[j]){
                    flag = false;
                    break;
                }else{
                    index++;
                }
            }
            if(flag)
                return true;
        }
        return false;
    }
}
