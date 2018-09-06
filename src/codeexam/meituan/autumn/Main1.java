package codeexam.meituan.autumn;

import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/6 18:27
 * @desc :
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int res = 0;
        if(x + y < 3){
            res = 0;
        } else if(x == y){
            res = (x + y) / 3;
        } else{
            while (x + y >= 3){
                int max = Math.max(x, y);
                int min = Math.min(x, y);
                x = max;
                y = min;
                x -= 2;
                y -= 1;
                res++;
                if(x != 0 && y == 0)
                    break;
                if(y != 0 && x == 0)
                    break;
            }
        }
        System.out.println(res);
        return;
    }
}
