package video.video2quickandheap;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 16:18
 * @desc :
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 9, 1, 0, 8, 5, 2, 5, 2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        return;
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left < right){
            int pivot = partition(array, left, right);
            quickSort(array, left, pivot - 1);
            quickSort(array, pivot + 1, right);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int pivot = array[left];
        while(left < right){
            while(left < right && array[right] >= pivot) right--;
            //swap(array, left, right);
            array[left] = array[right];

            while(left < right && array[left] < pivot) left++;
//            swap(array, left, right);
            array[right] = array[left];
        }
//        array[left] = pivot;
        array[left] = pivot;
        return left;

    }

    private static void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}
