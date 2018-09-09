package codeexam.bytedance.third;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/9/2018 10:35 AM
 * desc  :
 */
public class Main5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());



        int[][] relations = new int[M][2];
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>(N);
        for(int i = 0; i < N; i++){
            ArrayList<Integer> list = new ArrayList<>(N);
            list.add(i+1);
            resList.add(list);
        }

        int x, y;
        for(int i = 0; i < M; i++){
//            relations[i][0] = scanner.nextInt();
//            relations[i][1] = scanner.nextInt();
            x = scanner.nextInt();
            y = scanner.nextInt();
            resList.get(y-1).add(x);
        }

        if(N == 1){
            System.out.println(1);
            return;
        }

//        for(int i = 0; i < N; i++){
//            System.out.println(resList.get(i));
//        }

        for(int i = 0; i < N; i++){
            ArrayList<Integer> integers = resList.get(i);
            int[] tmpArr = new int[integers.size()];
            for(int j = 0; j < integers.size(); j++){
                tmpArr[j] = integers.get(j);
            }
            for(int j = 0; j < tmpArr.length; j++){
//                System.out.println(j);
                if(i == j)
                    continue;

                ArrayList<Integer> integers1 = resList.get(tmpArr[j] - 1);
//                System.out.println(integers1);
                getUnion(integers, integers1);
            }
            /*for(Integer j : integers){
                if(i == j)
                    continue;
                ArrayList<Integer> integers1 = resList.get(j);
                getUnion(integers, integers1);
            }*/
        }


        int res = 0;
        for(int i = 0; i < N; i++){
//            System.out.println(resList.get(i));
            if(resList.get(i).size() == N)
                res++;
        }
        System.out.println(res);

        /*int[][] resArr = new int[N][N];
        int x, y;
        for(int i = 0; i < M; i++){
            x = relations[i][0];
        }*/

//        System.out.println(Arrays.deepToString(relations));
        return;
    }

    public static void getUnion(ArrayList<Integer> list1, ArrayList<Integer> list2){
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < list2.size(); i++){
            tmp.add(list2.get(i));
        }
        tmp.removeAll(list1);
        list1.addAll(tmp);
    }
}
