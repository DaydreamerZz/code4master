package tookit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/8/11 15:42
 * @desc :
 */
public class Permutation {

    public static void main(String[] args) {

        int[] arr = new int[]{1,2,3};
//        char[] arr = new char[]{'a', 'a', 'z', 'z'};


        ArrayList<String> list = new ArrayList<>();
        permutation(arr, 0, list);

        for(String s: list){
            System.out.println(s);
        }
        return;
    }

    private static void permutation(int[] arr, int index, ArrayList<String > list) {
        if(index == arr.length-1){
            System.out.println(Arrays.toString(arr));
//            String s = Arrays.toString(arr);
//            if(!list.contains(s)){
//                list.add(s);
//            }
        }
        for(int i = index; i < arr.length; i++){
            int tmp = arr[index]; arr[index] = arr[i]; arr[i] = tmp;

            permutation(arr, index+1, list);
            tmp = arr[index]; arr[index] = arr[i]; arr[i] = tmp;
        }

    }
}
