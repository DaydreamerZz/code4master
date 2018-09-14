package codeexam.bytedance.first;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/12 9:51
 * @desc :
 */
public class Main3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = "";
        line = scanner.nextLine();
        int n = Integer.parseInt(line);
        ArrayList<Integer[]> list = new ArrayList<>();
        Integer[] tmp = new Integer[2];
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            tmp = new Integer[2];
            line = scanner.nextLine();
            String[] split = line.split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
            tmp[0] = Integer.parseInt(split[0]);
            tmp[1] = Integer.parseInt(split[1]);
            list.add(tmp);
        }
        list.sort(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[1] - o2[1];
            }
        });

//        for(Integer[] integers : list){
//            System.out.println(Arrays.toString(integers));
//        }
        long countKey = 0;
        long countValue = 0;
        boolean flag = false;
        for(int i = 0; i < list.size(); i++){
            countKey = 0;
            countValue = 0;
            for(int j = i; j < list.size(); j++){
                Integer[] integers = list.get(j);
                countKey += integers[0];
                countValue += integers[1];
            }
            if(countKey % 2 == 0){
                System.out.println(countValue);
//                flag = true;
                return;
            }else{
                continue;
            }
        }
        return;
    }
}
