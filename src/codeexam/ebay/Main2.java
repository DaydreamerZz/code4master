package codeexam.ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * author: Bruce Zhao
 * email : zhzh402@163.com
 * date  : 9/25/2018 7:00 PM
 * desc  :
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 1; i <= n; i++){
            arr[i-1] = i;
        }
//        int[] arr = new int[]{1,2,3};
//        char[] arr = new char[]{'a', 'a', 'z', 'z'};


        ArrayList<int[]> list = new ArrayList<>();
        ArrayList<int[]> resList = new ArrayList<>();
        permutation(arr, 0, list);

        int count = 0;
        int[] resArr = null;
        for(int[] array: list){
//            System.out.println(Arrays.toString(array));
            int[] tmpArr = new int[arr.length];
            for(int i = 0; i < tmpArr.length; i++){
                tmpArr[i] = array[i];
            }
            resList.add(tmpArr);
            if(mergeSort(array, 0, n-1) == t){
                count++;
            }else{
                resList.remove(resList.size()-1);
            }
        }

//        for(int[] array : resList){
//            System.out.println(Arrays.toString(array));
//        }
//        resList.remove(0);
        System.out.println(resList.size());
        int[] ints = resList.get(0);
        for(int i = 0; i < ints.length; i++){
            System.out.print(ints[i] + " ");
        }
        return;
    }

    private static void permutation(int[] arr, int index, ArrayList<int[] > list) {
        if(index == arr.length-1){
//            System.out.println(Arrays.toString(arr));
            int[] tmpArr = new int[arr.length];
            for(int i = 0; i < tmpArr.length; i++){
                tmpArr[i] = arr[i];
            }
            list.add(tmpArr);
//            System.out.println(Arrays.toString(tmpArr));
        }
        for(int i = index; i < arr.length; i++){
            int tmp = arr[index]; arr[index] = arr[i]; arr[i] = tmp;
            permutation(arr, index+1, list);
            tmp = arr[index]; arr[index] = arr[i]; arr[i] = tmp;
        }

    }

    private static int mergeSort(int[] array, int left, int right) {
        if(left == right)
            return 0;
        int mid = left + ((right - left) >> 1);
        return mergeSort(array, left, mid)
                + mergeSort(array, mid + 1, right)
                + merge(array, left, mid, right);
    }

    private static int merge(int[] array, int left, int mid, int right) {
        int count = 0;
        int[] helper = new int[right - left + 1];
        int l1 = left, l2 = mid + 1;
        int index = 0;
        //如果按照从小到大的顺序排列数组的话，假设现在左边部分已排序是3 4 5，右边部分是1 6，那么在合并的过程中按照小和问题的思路，3比1大，但是不能认为3比1之后的数都大。如果按照从大到小的顺序排列，那么左边是5 4 3，右边是6 1，判断5比1大是一个逆序，那么5之后所有的都是相对于1逆序的。
        while(l1 <= mid && l2 <= right){
            if(array[l1] < array[l2]){ //不符合逆序条件
                helper[index++] = array[l2++];
            } else{ //左边比右边大，那么左边当前位置开始，之后都是符合逆序的
                count += 1 * (right - l2 + 1);
                helper[index++] = array[l1++];
            }
        }

        while(l1 <= mid){
            helper[index++] = array[l1++];
        }

        while(l2 <= right){
            helper[index++] = array[l2++];
        }

        for(int i = 0; i < helper.length; i++){
            array[left + i] = helper[i];
        }
        return count;
    }
}
