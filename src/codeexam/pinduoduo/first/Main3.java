package codeexam.pinduoduo.first;

import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/5 19:00
 * @desc :
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int length = line.length();
        int k = length / 4;
        int h = k + 1;
        int m = (length - h * 2) / 2;
        m = 2 + m;

        parse(line, m, h);
        return;
    }

    private static void parse(String line, int m, int h) {
        char[][] res = new char[h][m];
        int index = 0;
        for(int i = 0; i < m; i++){
            res[0][i] = line.charAt(index++);
        }
        for(int j = 1; j < h; j++){
            res[j][m-1] = line.charAt(index++);
        }
        for(int i = m-2; i >= 0; i--){
            res[h-1][i] = line.charAt(index++);
        }
        for(int j = h-2; j > 0; j--){
            res[j][0] = line.charAt(index++);
        }
        for(int i = 0; i < res.length; i++){
            for(int j = 0; j < res[0].length; j++){
                if(res[i][j] != 0)
                    System.out.print(res[i][j]);
                else
                    System.out.print(" ");
            }
            if(i != res.length-1)
                System.out.println();
        }
    }
}
