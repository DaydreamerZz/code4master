package codeexam.pinduoduo.third;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/21 14:59
 * @desc :
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        double res = (double) a / c;
        DecimalFormat df = new DecimalFormat("0.00000");
        String str = df.format(res);
        System.out.println(str);
        return;
    }
}
