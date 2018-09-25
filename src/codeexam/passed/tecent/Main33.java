package codeexam.passed.tecent;

import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/16/2018 9:59 AM
 * desc  :
 */
public class Main33 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 2){
            System.out.println(4);
            return;
        }else if(n == 3){
            System.out.println(6);
            return;
        }
        //这里n大于等于4，假设是5，计算从1到5的最小公倍数，也就是[2,3,4]的最小公倍数
        int[] arr = new int[n-2];
        for(int i = 2, j = 0; i < n; i++, j++){
            arr[j] = i;
        }
        int tmp = arr[0];
        for(int i = 1; i < n-2; i++){
            tmp = getLCM(tmp, arr[i]);
        }
//        System.out.println(tmp);
        /*int backN = n;
        int start = n+1;
        while(true){

            int[] arr1 = new int[start - backN];
            int[] arr2 = new int[start-1];
            for(int i = 1; i <= arr1.length; i++){
                arr1[i-1] = backN + i;
            }
            for(int i = 2, j = 0; j < arr2.length; i++, j++){
                arr2[j] = i;
            }
            int tmp1 = arr1[0];
            for(int i = 1; i < arr1.length; i++){
                tmp1 = getLCM(tmp1, arr1[i]);
            }
            int tmp2 = arr2[0];
            for(int i = 1; i < arr2.length; i++){
                tmp2 = getLCM(tmp2, arr2[i]);
            }
            if(tmp1 == tmp2){
                System.out.println(start);
                break;
            }
            start += 1;
        }*/

        return;
    }

    private static int getLCM(int p, int q) {
        int backP = p;
        int backQ = q;
        if(p == 0)
            return q;
        //ensure p bigger than q
        if(p < q){
            int tmp = p + q;
            p = tmp - p;
            q = tmp - p;
        }

        int r = p % q;
        while(r != 0){
            p = q;
            q = r;
            r = p % q;
        }

        return backP * backQ / q;
    }
}
