package video.video1merge;

import java.util.Arrays;

/**
 * @author : Bruce Zhao
 * @email : zhzh402@163.com
 * @date : 2018/5/10 10:57
 * @desc : 归并排序
 * 空间复杂度O(n)，因为每一步的merge需要用一个辅助的数组，这个数组的长度就是原来的长度
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[]{4, 2, 9, 1, 0, 8, 5, 3};
        mergeSort(array, 0, array.length-1);
        System.out.println(Arrays.toString(array));
        return;
    }
    private static void mergeSort(int[] array, int left, int right) {
        if(left == right)
            return;
        int mid = left + ((right - left) >> 1);
        mergeSort(array, left, mid);
        mergeSort(array, mid+1, right);
        merge(array, left, mid, right);
    }
    private static void merge(int[] array, int left, int mid, int right) {
        int[] helper = new int[right - left + 1];
        int l1 = left, l2 = mid + 1;
        int helperIndex  = 0;

        while(l1 <= mid && l2 <= right){
            helper[helperIndex++] = (array[l1] < array[l2] ? array[l1++] : array[l2++]);
        }

        while(l1 <= mid){
            helper[helperIndex++] = array[l1++];
        }
        while(l2 <= right){
            helper[helperIndex++] = array[l2++];
        }

        for(int i = 0; i < helper.length; i++){
            array[left+i] = helper[i];
        }
    }
}
