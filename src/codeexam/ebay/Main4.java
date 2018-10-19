package codeexam.ebay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/10/19 20:03
 * @desc :
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] split = scanner.nextLine().split(" ");
        //int[] numbers = new int[n];

        int zeroCount = 0;
        ArrayList<Integer> boxs = new ArrayList<>();
        for (String str : split) {
            int i = Integer.parseInt(str);
            if(i == 0){
                zeroCount++;
            }else {
                boxs.add(i);
            }
        }

        /*
        for(int i : numbers){
            if(i == 0)
                zeroCount++;
        }*/



        Collections.sort(boxs);
        int rows = 0;
        boolean flag = false;
        while (true){
            if(boxs.size() < 1)
                break;
            int endOne = boxs.get(boxs.size()-1); //get largest one
            boxs.remove(boxs.size()-1);
            int sum = 0;
            for(int i = 0; i < boxs.size(); i++){
                int cur = boxs.get(i);
                sum += cur;
                if(sum <= endOne){
                    boxs.remove(i);
                    if(i <= boxs.size()-1 && sum >= boxs.get(i+1))
                        flag = true;
                }else{
                    break;
                }
            }
            rows++;
            if(flag)
                break;

        }

        System.out.println(rows+1);
        return;
    }
}
