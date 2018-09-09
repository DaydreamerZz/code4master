package codeexam.bytedance.third;

import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/9/2018 9:52 AM
 * desc  :
 */
public class Main3 {

    public static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int start = 0;
        int end = line.length() - 2;
        if(line.length() == 4){
            System.out.println(1);
            return;
        }else if(line.length() < 4){
            System.out.println(0);
            return;
        }else{
            StringBuilder sb = new StringBuilder(line);
            permutation(sb, start, end, 3);
        }

        System.out.println(res);
        return;
    }

    private static void permutation(StringBuilder sb, int start, int end, int count) {
        if(count == 0){
            System.out.println(sb.toString());
            char[] chars = sb.toString().toCharArray();
            boolean flag = true;
            for(int i = chars.length-1; i > 0; i--){
                if(chars[i] == '.' && chars[i-1] == '.'){
                    flag = false;
                    break;
                }
            }
            if(flag)
                res++;
        }

        for(int i = start; i < end; i++) {
            StringBuilder backLine = new StringBuilder(sb.toString());

            sb.insert(start+i+1, ".");

            permutation(sb, start+1, end, count - 1);

            sb = backLine;
        }


    }
}
