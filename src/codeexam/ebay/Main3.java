package codeexam.ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/19 19:43
 * @desc :
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(" ");
        int[] numbers = new int[n];
        int index = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for (String str : split) {
            numbers[index++] = Integer.parseInt(str);
        }
        int max = -1;
        int sum = 0;
        if (n == m) {
            max = getMax(numbers);
            System.out.println(max);
            return;
        } else if (m == 1) {
            for (int i = 0; i < numbers.length; i++) {
                sum += numbers[i];
            }
            System.out.println(sum);
            return;
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Integer i : numbers){
            list.add(i);
        }

        ArrayList<Integer> tmpList = new ArrayList<Integer>();
        while (list.size() != m) {
            max = Collections.max(list);
            for(int i = 1; i < list.size(); i++){
                int tmpSum = list.get(i) + list.get(i-1);
                if(tmpSum <= max){
                    tmpList.add(tmpSum);
                }
            }
            int min = Collections.min(tmpList);
            int left = 0;
            int right = 0;
            for(int i = 1; i < list.size(); i++){
                int tmpSum = list.get(i) + list.get(i-1);
                if(min == tmpSum){
                    left = i-1;
                    right = i;
                    break;
                }
            }
            list.remove(right);
            list.remove(left);
            list.add(left, min);

        }

        System.out.println(Collections.max(list));
        return;
    }

/*
7 5
100 400 300 100 500 101 400
*/
    public static int getMax(int[] numbers) {
        int max = -1;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }
}
