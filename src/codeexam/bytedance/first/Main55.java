package codeexam.bytedance.first;

import java.util.Scanner;
import java.util.TreeMap;
/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 8/12/2018 11:30 AM
 * desc  :
 */
public class Main55 {
    private static TreeMap<Integer, Integer> treeMap = new TreeMap();
    private static int M;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = Integer.parseInt(s.nextLine());
        M = Integer.parseInt(s.nextLine());
        String str = s.nextLine();
        String[] strings = str.split(" ");
        for (int i = 0; i < N; i++) {
            int start = Integer.parseInt(strings[i * 2]);
            int end = Integer.parseInt(strings[i * 2 + 1]);
            treeMap.put(start, end);
        }
        int end = -1;
        boolean flag = true;
        int res = 1;
        for (int key : treeMap.keySet()) {
            if (flag) {
                end = treeMap.get(key);
                flag=false;
            }
            if (key < end){
                int nextEndTime = treeMap.get(key);
                if(nextEndTime == 0)
                    nextEndTime = M;
                if (nextEndTime<end){
                    end = nextEndTime;
                }
                continue;
            }

            flag = true;
            res++;
        }
        System.out.println(res);

    }

}