package codeexam.meituan.autumn;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/6 18:27
 * @desc :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[][] costAndgain = new int[count][4];
        for(int i = 0; i < count; i++){
            String[] split = scanner.nextLine().split(" ");
            costAndgain[i][0] = Integer.parseInt(split[0]);
            costAndgain[i][1] = Integer.parseInt(split[1]);
            costAndgain[i][2] = Integer.parseInt(split[2]);
            costAndgain[i][3] = Integer.parseInt(split[3]);
        }

        int[][] dp = new int[count][121];
        for(int i = 1; i <= 120; i++){
            if(i >= costAndgain[0][0]){
                dp[0][i] = costAndgain[0][1];
            }
            if(i >= costAndgain[0][2]){
                dp[0][i] = Math.max(costAndgain[0][1], costAndgain[0][3]);
            }
        }

        for(int i = 1; i < count; i++){
            for(int j = 1; j <= 120; j++){
//                int x  = 0, y = 0;
                /*if(j >= costAndgain[i][0]) {
                    x = dp[i - 1][j - costAndgain[i][0]] + costAndgain[i][1];
                }else {
                    x = costAndgain[i][1];
                }
                if(j >= costAndgain[i][2]) {
                    y = dp[i - 1][j - costAndgain[i][2]] + costAndgain[i][3];
                }else{
                    y = costAndgain[i][3];
                }
                dp[i][j] = Math.max(x, y);*/
                if(j < costAndgain[i][0]){
                    dp[i][j] = dp[i-1][j];
                }else if(j >= costAndgain[i][0] && j < costAndgain[i][2]){
                    int x = costAndgain[i][1];
                    int y = dp[i][costAndgain[i][0]] + dp[i-1][j-costAndgain[i][0]];
                    dp[i][j] = Math.max(x, y);
                }else if(j >= costAndgain[i][2]){
                    int x = costAndgain[i][3];
                    int y = dp[i][costAndgain[i][2]] + dp[i-1][j-costAndgain[i][2]];
                    int z = dp[i][costAndgain[i][0]] + dp[i-1][j-costAndgain[i][0]];
                    dp[i][j] = Math.max(x, y);
                    dp[i][j] = Math.max(z, dp[i][j]);
                    if(j >= (costAndgain[i][0]+costAndgain[i][2])){
                        int w = costAndgain[i][1] + costAndgain[i][3];
                        dp[i][j] = Math.max(w, dp[i][j]);
                    }
                }


//                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
            }
        }


        /*for(int i = 0; i < count; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }*/
        int max = 0;
        for(int i = 0; i < count; i++){
            for(int j = 0; j <= 120; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        System.out.println(max);
//        System.out.println(dp[count-1][120]);
//        System.out.println(Arrays.deepToString(costAndgain));
        return;
    }
}
