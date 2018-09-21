package codeexam.pinduoduo.third;

import java.util.*;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/9/21 14:58
 * @desc :
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] goods = new int[n];
        int totalPrice = 0;
        for(int i = 0; i < n; i++){
            goods[i] = scanner.nextInt();
            totalPrice += goods[i];
        }
        scanner.nextLine();
        int[][] prices = new int[m][2];
        for(int i = 0; i < m; i++){
            prices[i][0] = scanner.nextInt();
            prices[i][1] = scanner.nextInt();
            scanner.nextLine();
        }


        int[][] dp = new int[totalPrice+1][m];

        for(int i = 0; i <= totalPrice; i++){
            for(int j = 0; j < m; j++){
                if(i < prices[j][0]){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = i - prices[j][1];
                }
            }
        }

        /*int index = 0;
        for(int[] ints : dp){
            System.out.println(index++ + Arrays.toString(ints));
        }*/


        int count = 0;
        HashSet<Integer> used = new HashSet<>();
        while(true){
            int[] curArr;
            if(count == 0) {
                 curArr = dp[totalPrice];
            }else {
                curArr = dp[count];
            }
            boolean flag = true;
            for(int i = 0; i < curArr.length; i++){
                if(curArr[i] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                break;

            ArrayList<Integer> tmpList = new ArrayList<>();
            for(int i = 0; i < curArr.length; i++){
                tmpList.add(curArr[i]);
            }
            while(true) {
                int tmpIndex = getMinIndex(tmpList);
                if(used.contains(tmpIndex)){
                    tmpList.set(tmpIndex, 0);
                }else{
                    used.add(tmpIndex);
                    if(used.size() == m){
                        System.out.println(count);
                        return;
                    }
                    count += curArr[tmpIndex];
                    break;
                }
            }



        }
        System.out.println(count);
        return;
    }

    private static int getMinIndex(ArrayList<Integer> curArr) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        for(int i = curArr.size()-1; i>=0; i--){
            if(curArr.get(i) < min && curArr.get(i) != 0){
                min = curArr.get(i);
                index = i;
            }
        }
        return index;
    }
}

/*
3 3
5 10 15
10 6
20 10
30 15
 */
