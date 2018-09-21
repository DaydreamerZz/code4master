package codeexam.passed.tecent;

import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/16/2018 9:58 AM
 * desc  :
 */

/*
1
91 16 5
1
58 16 0
1
96 12 4
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int a, b, c;

        for(int i = 0; i < n; i++){
            boolean flag = true;
            String[] split = scanner.nextLine().split(" ");
            a = Integer.parseInt(split[0]);
            b = Integer.parseInt(split[1]);
            c = Integer.parseInt(split[2]);

            int start = a / b;
            for(int j = 0; j < 10000; j++){
                int tmp = b * (start+j) + c;
                if(tmp % a == 0){
                    System.out.println("YES");
                    flag = false;
                    break;
                }
            }
            if(flag)
                System.out.println("NO");
        }

        return;
    }
}
